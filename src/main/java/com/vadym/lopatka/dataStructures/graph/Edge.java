package com.vadym.lopatka.dataStructures.graph;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Edge {
    public Node start;
    public Node end;
    public double weight;
}