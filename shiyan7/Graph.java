package lab1;

import java.util.List;
public class Graph{
    int wordNum;//¶¥µãÊý
    int nnn;
    List<String> wordList; 
    int[][] E;
    public Graph(List<String> wordList,int[][] E,int wordNum){
        this.wordList = wordList;
        this.E = E;
        this.wordNum = wordNum;
    }
    
}
