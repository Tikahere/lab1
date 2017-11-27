package lab1;

import java.util.List;
public class Graph{
    int wordNum;//顶点数
    int nnn;
    List<String> wordList; //顶点集
    int[][] E; //边集
    public Graph(List<String> wordList,int[][] E,int wordNum){
        this.wordList = wordList;
        this.E = E;
        this.wordNum = wordNum;
    }
    
}
