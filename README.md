# dijkstra algorithm

Algoritmo que calcula o caminho mais curto, em termos de peso total das arestas, entre um nó inicial e todos os nós do grafo.

![Initial Graph](https://github.com/thiagotn/dijkstra/blob/master/src/main/resources/initial-graph.png)

### Run

    mvn compile

    mvn exec:java -Dexec.mainClass=cc.thiago.dijsktra.App

    or Run > App.java

### Expected output

    Dijkstra algorithm!
    The shortest paths from Node A are as follows:
    from Node A to Node B: A -> B (total distance = 10) 
    from Node A to Node C: A -> C (total distance = 15) 
    from Node A to Node D: A -> B -> D (total distance = 22) 
    from Node A to Node F: A -> B -> D -> F (total distance = 23) 
    from Node A to Node E: A -> B -> D -> E (total distance = 24) 

### References

https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm


