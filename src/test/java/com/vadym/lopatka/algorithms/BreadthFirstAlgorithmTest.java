package com.vadym.lopatka.algorithms;

import com.vadym.lopatka.dataStructures.DirectedGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class BreadthFirstAlgorithmTest {

    private HashMap<String, HashMap> you;

    @Before
    public void setUp() throws Exception {
        // first-degree friends   you = [Claire, Alice, Bob]
        // second-degree friends  Claire = [Thom, Jonny]
        // second-degree friends  Alice = [Peggie]
        // second-degree friends  Bob = [Anuj, Peggie]

        HashMap<String, HashMap> anuj = new HashMap<>();
        HashMap<String, HashMap> peggie = new HashMap<>();
        HashMap<String, HashMap> thom = new HashMap<>();
        HashMap<String, HashMap> jonny = new HashMap<>();

        HashMap<String, HashMap> bob = new HashMap<>();
        bob.put("Anuj", anuj);
        bob.put("Peggie", peggie);

        HashMap<String, HashMap> alice = new HashMap<>();
        bob.put("Peggie", peggie);

        HashMap<String, HashMap> claire = new HashMap<>();
        bob.put("Thom", thom);
        bob.put("Jonny", jonny);

        you.put("Claire", claire);
        you.put("Alice", alice);
        you.put("Bob", bob);

    }

    @Test
    public void findClosestWayToFriendsFriend() {

    }
}