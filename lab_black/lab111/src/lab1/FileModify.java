package lab1;
/**
 * 头文件
 */
//import java.lang.NullPointerException;
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileReader;  
import java.io.FileWriter;
import java.util.regex.Matcher;  
import java.util.regex.Pattern; 
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.lang.Character;
import java.util.Arrays;


public class FileModify{
	
	/**
	 * 程序入口
	 * @param args
	 * @throws IOException
	 */
   public static void main(String[] args) throws IOException {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("请输入文件名:");
	   String fileName = sc.nextLine();
	   BufferedReader br = new BufferedReader(new FileReader(fileName));
	   String line;
	   String deStr = "";
	   while((line = br.readLine()) != null){
		   deStr += line;
		   System.out.println(line);
	   }

	   
	   //将文件内容读入
	   try {  
           fileContent = readFile(new File(fileName));  
       } catch (Exception e) {  
           e.printStackTrace();  
       }    
	   output(fileContent);
	   String st = new String(sb2);
	   //将更新的文件内容写入一个新的文件中
	   try {  
             writeFile(st, filePath); //st为字符串
       } catch (Exception e) {  
           e.printStackTrace();  
       }
	   //
//     Scanner wor1 = new Scanner(System.in);
//     Scanner wor2 = new Scanner(System.in);
//     System.out.println(glob);
//     System.out.println("请输入两个单词");
//     String st1 = wor1.nextLine();
//     String st2 = wor2.nextLine();
//
//     //queryBridgeWords(st1,st2);
//     System.out.println(queryBridgeWords(st1,st2));
     linjie();
     //System.out.println(shiji);
     //功能四，生成新文本
     Scanner yonghu = new Scanner(System.in);
     System.out.println("用户输入：");
     str3 = yonghu.nextLine();
     countWord();
//     for (int i =0;i<yhcun.length;i++){
//         System.out.print(yhcun[i]);
//         System.out.print(" ");
//     }
     
     generateNewText();
//     System.out.println(generateNewText());
//     //shortestPath_FLOYD();
//	   //shortestPath_FLOYD();
//     
//	   randomWalk();
////	   String gnl = new String(gnliu);
////	   try {  
////           writeFile(gnl, Path); //st为字符串
////     } catch (Exception e) {  
////         e.printStackTrace();  
////     }
	   br.close();
	   sc.close();
	}
   public static String filePath = new String("G:/content.txt");
   public static String Path = new String("G:/gongnliu.txt");
   public static String fileContent = new String();  
   public static HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
   public static String[] cun = new String[100000];//文本文件中所有的单词
   public static String[] lingcun = new String[100000];//文本文件中的单词去重另存的数组
   public static String str3 = new String();
   public static String[] yhcun = new String[100000];
//  public static String[][][] jingguo = new String[1000][1000][1000];
   public static StringBuffer sb2 = new StringBuffer();
   public static int glob;
   public static int shiji;
   public static int yhglob;
   public static int yipipei;
   public static String first_Bridge = new String();

   public static int[][] w1 =new int[1000][1000];
   public static String[] yzcun = new String[100000];
   public static StringBuffer gnliu = new StringBuffer();
   
   public static void countWords() {  
       Pattern expression = Pattern.compile("[a-zA-Z]+");// 定义正则表达式匹配单词  
       String string1 = fileContent.toLowerCase();// 转换成小写  
       Matcher matcher = expression.matcher(string1);  
       String word = null;// 文章中的单词  
       int i =0;
       while (matcher.find()) {// 是否匹配单词  
           word = matcher.group();// 得到一个单词-树映射的键
           cun[i] = word;
           //cun[i+1] = " ";
           //System.out.println(cun[i]);
           //System.out.println(cun[i+1]);
           
           sb2.append(cun[i]);
           sb2.append(" ");
           //System.out.println(sb2);
           i=i+1;
           if (wordsCount.containsKey(word)) {  
               wordsCount.put(word, wordsCount.get(word) + 1);  
           } else {  
               wordsCount.put(word, 1);  
           }  
       }
       glob=i;
       System.out.println(sb2);
       System.out.println(i);
//       for(int j = 0;j<glob;j++){
//	        // if wordlist no contain word , then add
//	        
//	        if (!wordList.contains(cun[j]) ) {
//	            wordList.add(cun[j]);
//	            // recored word number
//	        }   
//	    }
//       int t = wordList.indexOf(word);
   }
   
   //利用hash表提取单词
   public static void output(String outputString) {  
       System.out.println("您输入的文本由txt中读取出来咯，内容是：");  
       System.out.println(outputString);  
       countWords();  
       //System.out.println(wordsCount);
       System.out.println("输入的文本中共有" + wordsCount.size() + "个英语单词。");  
       shiji = wordsCount.size();
       System.out.println("统计分析如下（已忽略大小写）：");  
       //String[] cun = new String[wordsCount.size()];
       int i = 0;
       for (Iterator<String> iterator = wordsCount.keySet().iterator(); iterator  
               .hasNext();) {  
           String words = (String) iterator.next();  
           lingcun[i] = words;
           System.out.println(lingcun[i]);
           i++;
           int num1 = wordsCount.get(words);  
           System.out.println("\"" + words + "\"出现了" + num1 + "次");  
       } 
   }
   
   public static String readFile(File file) throws Exception {  
       BufferedReader br = new BufferedReader(new FileReader(file));  
       System.out.println("打开文件成功！");  
       StringBuffer sbf = new StringBuffer("");  
       String line = null;  
       while ((line = br.readLine()) != null) {  
           sbf.append(line).append("\r\n");// 按行读取，追加换行\r\n  
       }  
       System.out.println("文件内容读取成功！");  
       br.close();  
       return sbf.toString();  
   }
   public static void writeFile(String str, String savePath) throws Exception {  
       System.out.println("txt保存路径是：" + savePath);  
       BufferedWriter bw = new BufferedWriter(new FileWriter(savePath));  
       System.out.println("txt创建成功！");  
       bw.write(str);  
       System.out.println("文本内容存储到txt中成功！");  
       bw.close();  
 
   }
   /*public static void getweigh(String[] m){
	   int weight = 1;
	   for (int i = 0;i<2*wordsCount.size();i = i+2){
		   for (int j = i+1;j<wordsCount.size();j = j+2){
			   if (m[i] == m[j]&&m[i+2]==m[j+2]){
				   weight = weight+1;
			   }
		   }
	   }
   }*/
   
   //桥接词函数
   public static String queryBridgeWords(String word1, String word2)
   {
       String[] cu = {"if","not","the","sun","for","smiling","to","if","turned","the","to","found","at","we","now","he"};
     int cishu = 0;//cishu标记的是第几次遇到匹配的情况；
     int flag1=0;//flag1,flag2分别是标记Word1，Word2是否存在的变量
     int flag2=0;
     //int yipipei=0;//标记是否已找到桥接词的变量
     boolean re1;
     boolean re2;
     String result;
     StringBuffer sb3= new StringBuffer();
     
     for(int m = 0;m<15;m++)//判断word1与word2的存在情况
     {
    	 re1 = cu[m].equals(word1);
    	 re2 = cu[m].equals(word2);
       if(re1==true){flag1=1;}
       else if(re2==true){flag2=1;}
       if(flag2==1 && flag1==1){break;}
     }
//     System.out.println(flag1);
//     System.out.println(flag2);
     
     if(flag1==0 && flag2==0)
     {
         result = "No "+word1+" and "+word2+" in the graph!";
         //System.out.println(result);
     }
     else if(flag1==0)
     {
         result = "No "+word1+" in the graph!";
         //System.out.println(result);
     }
     else if(flag2==0)
     {
         result = "No "+word2+" in the graph!";
         //System.out.println(result);
     }
     //以上是两个词不全都存在于文本中的情况
     else
     {
       for(int i = 0;i<13;i++)
       {
    	  re1 = cu[i].equals(word1);
      	  re2 = cu[i+2].equals(word2);
         if(re1==true)
         {         
           if(re2==true)
           {
             yipipei=1;
             if(cishu==0)
             {
               sb3.append("The bridge words from "+word1+" to "+word2+" are: "+cu[i+1]+",");
//               System.out.print("The bridge words from "+word1+" to "+word2+" are: "+cun[i+1]+",");
               cishu+=1; 
               first_Bridge=cu[i+1];

             }
             else
             {
                 sb3.append(cu[i+1]);
                 sb3.append(",");
               //System.out.print(cun[i+1]+",");
               cishu+=1;
             }
           }
           else{continue;}                    
         }       
       }
       
       if(yipipei==1)
       {
           sb3.append(".");
           result = sb3.toString();
//           System.out.println(result);
//           System.out.println(".");
       }
       else
       {
           result = "No bridge words from "+word1+" to "+word2+"!";
           //System.out.println(result);
       }
     }
     return result;
   }

   //邻接矩阵
   public static void linjie(){
	   int[][] w =new int[shiji][shiji];
	   for(int i=0;i<glob;i++)
	   {
		   System.out.print(cun[i]);
		   System.out.print(" ");
	   }
	   System.out.print("\n");
	   for(int i=0;i<shiji;i++)
	   {
		   System.out.print(lingcun[i]);
		   System.out.print(" ");
	   }
	   for(int i =0;i<shiji;i++)
	   {
		   for(int j = 0;j<shiji;j++){
			   w[i][j]=0;
		   }
	   }
	   for(int i = 0;i<shiji;i++){
		   for(int j = 0;j<shiji;j++)
		   {
			   for(int k = 0;k<glob-1;k++)
			   {
				   int sy1 = cun[k].compareTo(lingcun[i]);
				   int sy2 = cun[k+1].compareTo(lingcun[j]);
				   
			   //System.out.print(lingcun[j]);
			       if(sy1==0&&sy2==0)
			       {
				        w[i][j]++;
			       }
			   }
			   //System.out.print("\n");
		   }
	   }
	   for(int i = 0;i<shiji;i++)
	   {
		   for(int j = 0;j<shiji;j++)
		   {
			   if (w[i][j]>0)
			   {
				   System.out.println(lingcun[i]+"->"+lingcun[j]+"="+w[i][j]);
				   w1[i][j] = w[i][j];
			   }
		   }
	   }
       
	   for(int i = 0;i<shiji;i++)
	   {
		   for(int j = 0;j<shiji;j++)
		   {
			   
			   System.out.print(w[i][j]);
			   System.out.print(" ");
		   }
		   System.out.print("\n");
	   }
   }
   public static void countWord() {  
       Pattern expression = Pattern.compile("[a-zA-Z]+");// 定义正则表达式匹配单词  
       String string1 = str3.toLowerCase();// 转换成小写  
       Matcher matcher = expression.matcher(string1);  
       String word = null;// 文章中的单词  
       int i =0;
       while (matcher.find()) {// 是否匹配单词  
           word = matcher.group();// 得到一个单词-树映射的键
           yhcun[i] = word;
           System.out.println(yhcun[i]);
           i=i+1; 
       }
       yhglob=i;
       //System.out.println(sb2);
       System.out.println(i);
   }
   
   public static String generateNewText()//yipipei现在是全局变量
   {
       String yh_out = new String();//用来输出由用户输入的文本所补充出的新文本内容
       String[] yc = {"if","sun"};
       for(int i=0;i<2-1;i++)
       {
           queryBridgeWords(yc[i],yc[i+1]);
           //queryBridgeWords("not","sun");
           if(yipipei==1)//////////////////////////////////////////////////////////////////////////////////////////////////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
           {
//               yh_out=String.format("%s "+"%s "+"%s ",yh_out ,yc[i] , first_Bridge);
               yh_out=String.format("%s "+"%s ",yc[i] , first_Bridge);
//               System.out.println(yh_out);
//               System.out.println(yc[i]);
//               System.out.println(first_Bridge);
           }
           else
           {
//               yh_out=String.format("%s ",yh_out );
//               yh_out=String.format("%s "+"%s ",yh_out , yc[i]);
               yh_out=String.format("%s ", yc[i]);
               System.out.println(yh_out);
               System.out.println(yc[i]);
           }

   //插入该桥连接词
       }
       yh_out=String.format(yh_out + yc[1]);
//       yh_out=String.format(yh_out);
//       yh_out =  " not the sun";
       System.out.println(yh_out);
       return yh_out;
   }

   public static int[] s = new int[1000];
   public static int[] he = new int[1000];
   public static int m = 0;
   public static class MGraph {
	    /*图的邻接矩阵表示*/
	    int vexs;  //图中结点数目
	    String data[];  //存放结点数据
	    int [][]weight;  //存放边
	    public MGraph(int ve){
	        vexs=ve;
	        data=new String[ve];
	        weight=new int[ve][ve];
	    }       
	}
 //随机游走
   public static class GraphMetrix {
   public void CreateGraph(MGraph graph){
       int i,j;
       for(i=0;i<shiji;i++){
           graph.data[i]=lingcun[i];
           for(j=0;j<shiji;j++){
               graph.weight[i][j]=w1[i][j];
           }
       }
   }
   public void ShowGraph(MGraph graph){
       int vexs=graph.vexs;
       int [][]weight=graph.weight;
       int i,j;
       for(i=0;i<vexs;i++){
           System.out.print(graph.data[i]+":");
           for(j=0;j<vexs;j++){
               System.out.print(weight[i][j]+" ");
           }
           System.out.println();
       }
   }
   public int GetFirst(MGraph graph,int k){
       int i;
       if(k<0||k>graph.vexs-1){
           System.out.println("参数k值超出范围");
           return -1;
       }
       for(i=0;i<graph.vexs;i++){
           if(graph.weight[k][i]>=1)
               return i;
       }
       return -1;
   }
   public int GetNext(MGraph graph,int k,int t){
       int i;
       if(k<0||k>graph.vexs-1||t<0||t>graph.vexs-1){
           System.out.println("参数k或t值超出范围");
           return -1;
       }
       for(i=t+1;i<graph.vexs;i++){
           if(graph.weight[k][i]>=1)
               return i;
       }
       return -1;
   }
//   public static int[] s = new int[shiji];
//   public static int m = 0;
   public void DFSVGraph(MGraph graph,int k,int visited[]){
       /*graph为图的邻接矩阵表示，k为起始顶点，visited[]为访问过标记数组*/
	  
       int u;   //k的邻接顶点
       s[m] = k;
       //String yi = graph.data[k];
       System.out.print(graph.data[k]+", ");
       System.out.print(s[m]);
       //yzcun[s] = graph.data[k];
//       System.out.println("\n");
//       System.out.println(graph.data[s]+", ");
       visited[k]=1;//表示顶点k被访问过
       u=GetFirst(graph,k);//获取k的第一个邻接顶点u
       m++;
       while(u!=-1){
           if(visited[u]==0){  //如果u未被访问过，则递归访问u的邻接点
               DFSVGraph(graph,u,visited);
           }
           u=GetNext(graph,k,u);//获取k的下一个邻接顶点
           
       }
       
//       if(u != k&&graph.data[k].compareTo(yi)==0)
//       {
//    	   System.out.print(graph.data[k]+", ");
//       }
   }
   }
   public static void  randomWalk(){
   	Random rand = new Random();
   	int randNum = rand.nextInt(shiji);
//   	nVerts = shiji;
//   	vertexList = Arrays.asList(lingcun);
   	System.out.println(randNum);
    int vexs=shiji;
    int visited[]=new int [vexs];/*定义访问标记数组*/
    
    for(int i=0;i<vexs;i++){
        /*初始化访问标记数组*/
        visited[i]=0;
    }
    for (int i = 0;i<shiji;i++)
    {
    	for(int j = 0;j<shiji;j++)
    	{
    		he[i]+=w1[i][j];
    	}
    	System.out.println(he[i]);
    }
    MGraph graph=new MGraph(vexs);
    GraphMetrix gam=new GraphMetrix();

    gam.CreateGraph(graph);
    gam.ShowGraph(graph);
    gam.DFSVGraph(graph, randNum, visited);
    System.out.println("++++");
    for (int i = 0;i<shiji;i++)
    {
    	System.out.println(s[i]);
    	sb2.append(cun[i]);
        sb2.append(" ");
    	gnliu.append(lingcun[s[i]]);
    	gnliu.append(" ");
    	System.out.println(lingcun[s[i]]);

    	if(he[s[i]]==0)
    	{
    		break;
    	}
//    	for(int j = s[2];j<shiji;j++){
//    		if (w1[i][s[0]]>0&&w1[s[0]][j]>0)
//    	    {
//    		    System.out.println(lingcun[s[1]]);
//    	    }
//    	}
////    	if(he[s[i]]>w1[s[i]][s[i+1]])
////    	{
////    		gnliu.append(lingcun[s[i]]);
////	    	gnliu.append(" ");
////	    	System.out.println(lingcun[s[i]]);
//    	}
    	if(he[s[i]]==w1[s[i]][s[0]])
    	{
    		if(he[s[i]]>w1[s[i]][s[i+1]])
            {
        		gnliu.append(lingcun[s[i]]);
    	    	gnliu.append(" ");
    	    	System.out.println(lingcun[s[i+1]]);
    	    	//System.out.println(lingcun[s[i+2]]);
        	}
//    		if (he[s[0]]>w1[s[0]][s[1]]){
//    			gnliu.append(lingcun[s[0]]);
//    	    	gnliu.append(" ");
//    			System.out.println(lingcun[s[0]]);
//    		}
    		else{
    			gnliu.append(lingcun[s[0]]);
    	    	gnliu.append(" ");
    		System.out.println(lingcun[s[0]]);
    		break;}
    	}
    	for(int j = 0;j<i;j++){
    		if(w1[s[i]][j]>0)
    		{
    			System.out.println(lingcun[s[j]]);
    			//System.out.println(lingcun[s[j+1]]);
//    			gnliu.append(lingcun[s[j]]);
//    	    	gnliu.append(" ");
//    	    	gnliu.append(lingcun[s[j+1]]);
//    	    	gnliu.append(" ");
    		}
    	}
    	if (w1[s[i]][s[i+1]]==0)
    	{
    		break;
    	}
    	
    	
    }
    
    System.out.println(gnliu);
    gnliu.reverse();
    System.out.println(gnliu);
    StringBuffer sb1 = new StringBuffer();
    for(int i = 1;i<gnliu.length();i++)
    {
    	sb1.append(gnliu.charAt(i));
    	if(gnliu.charAt(i)==' ')
    		break;
    }
    System.out.println(sb1);
    sb1.reverse();
    System.out.println(sb1);
    gnliu.reverse();
    StringBuffer sb4 = new StringBuffer();
//    String st5 = new String();
//    String str = new String(buffer);
    for(int i = 1;i<sb1.length();i++)
    {
    	if(sb1.charAt(i)!=0)
    	sb4.append(sb1.charAt(i));
    }
    System.out.println(sb4);
    System.out.println(sb4.length());
    String st5 = new String(sb4);
    for (int i = 0;i<glob;i++)
    {
    	if(st5.compareTo(cun[i])==0&&cun[i+1]!=null){
    		System.out.println(cun[i+1]);
    		gnliu.append(cun[i+1]);
    		//break;
    	}
    	
    }
   
    System.out.println(gnliu);
   }
   


   
}