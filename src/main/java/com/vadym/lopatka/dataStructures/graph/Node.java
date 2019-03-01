package com.vadym.lopatka.dataStructures.graph;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Node {
    public String name;
    public List<Edge> connections;
}