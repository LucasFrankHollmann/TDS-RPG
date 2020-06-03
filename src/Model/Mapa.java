package Model;

class Mapa {
    
    protected MapNode[] node = new MapNode[20];
    
    /**
     * @param mapNodeAtual qual o nó atual que o personagem está
     * @return o nó que ele vai
     */
    MapNode getNodeAtual(int mapNodeAtual) {
        return node[mapNodeAtual];
    }
    
}