package com.flucta.runtime.launcher.inputparser;

import com.flucta.core.graph.Graph;

import java.io.File;

public interface Parse {
    Graph parse(File file);
}
