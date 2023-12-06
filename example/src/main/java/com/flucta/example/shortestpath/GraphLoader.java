package com.flucta.example.shortestpath;

import com.flucta.core.graph.Graph;
import com.flucta.core.graph.vertex.Vertex;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GraphLoader<T> {
    public static Graph<Double> loadGraph(String filePath) {
        Graph<Double> graph = new Graph<>(new ArrayList<Vertex<Double>>());
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell fromVertexCell = row.getCell(0);
                Cell toVertexCell = row.getCell(1);
                Cell weightCell = row.getCell(2);

                if (fromVertexCell != null && toVertexCell != null && weightCell != null) {
                    int fromVertexId = (int) fromVertexCell.getNumericCellValue();
                    int toVertexId = (int) toVertexCell.getNumericCellValue();
                    double edgeWeight = Math.abs(weightCell.getNumericCellValue());

                    if (graph.getVertexById(fromVertexId) == null) {
                        FloodingVertex vertex = new FloodingVertex(fromVertexId, new FloodingValue(10000));
                        graph.addVertex(vertex);
                    }
                    if (graph.getVertexById(toVertexId) == null) {
                        FloodingVertex vertex = new FloodingVertex(toVertexId, new FloodingValue(10000));
                        graph.addVertex(vertex);
                    }
                    graph.getVertexById(fromVertexId).addNeighbor(graph.getVertexById(toVertexId), new FloodingValue(edgeWeight));
                }
            }
            return graph;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
