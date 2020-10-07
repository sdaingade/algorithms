package tests;
// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.


// char [][] ch = {
//                 'a','y','a','l'
//                 'm','a','n','k'
//                 'a','y','l','g'
//                 'b','x','d','e'
//               }
               
//   String str = "mayank" =>   [1,0][0,0][0,1][0,2][1,2][1,3]
   
//   public void printAllPaths(String str,char[][]ch)
   
//char[][] ch = {
//                 {'a','y','a','l'},
//                 {'m','a','n','k'},
//                 {'a','y','l','g'},
//                 {'b','x','d','e'},
//               }



//Swapnil Daingade
// Did minimal fixes to get it running.
// Note that the path is being print in reverse.
// Kept it the same as did not want to make lot of changes to existing code.



//String to search:mayank
//[1,3]
//[1,2]
//[1,1]
//[0,1]
//[0,0]
//[1,0]
//Found match!!!
//Found! match for mayank
//String to search:ayanaylgedxb
//[3,0]
//[3,1]
//[3,2]
//[3,3]
//[2,3]
//[2,2]
//[2,1]
//[1,1]
//[1,2]
//[0,2]
//[0,1]
//[0,0]
//Found match!!!
//Found! match for ayanaylgedxb

public class FindPaths {

 private char[][] ch = {
                 {'a','y','a','l'},
                 {'m','a','n','k'},
                 {'a','y','l','g'},
                 {'b','x','d','e'},
               };

 private boolean[][] visited = {
                 {false,false,false,false},
                 {false,false,false,false},
                 {false,false,false,false},
                 {false,false,false,false},
               };

  private int length = 4;
  private int breadth = 4;
  private String toSearch;
  
  public boolean searchString(String search) {
      System.out.println("String to search:" + search);
      toSearch = search;
      clearVisited();

      for(int i = 0; i < length; i++) {
        for(int j = 0; j < breadth; j++) {
          //System.out.println("[" + i + "," + j + "]");
          if(ch[i][j] == toSearch.charAt(0)) {
              int p = i;
              int q = j;
              if (startSearch(p,q, 0)) {
                  System.out.println("Found match!!!");
                  return true;
              }
              clearVisited();
          }
        }
      }
      return false;
  }
  
  private boolean startSearch(int i, int j, int index) {
     //System.out.println("Start search: i:" + i + " j:" + j + " index:" + index);
      visited[i][j] = true;

      if (index == toSearch.length() -1) {
    	  System.out.println("[" + i + "," + j + "]");
    	  return true;
      }
      //System.out.println("At char:" + ch[i][j] + " row:" + i + " col:" + j);

      boolean found = false;

      if (isValidMoveTop(i,j,index+1)) {
          found = startSearch(i - 1, j, index + 1);
      }
      if (!found && isValidMoveBottom(i,j,index+1)) {
          found = startSearch(i + 1, j, index + 1);
      }
      if (!found && isValidMoveLeft(i,j,index+1)) {
          found = startSearch(i, j - 1, index + 1);
      }
      if (!found && isValidMoveRight(i,j,index+1)) {
          found = startSearch(i, j + 1, index + 1);
      }
      
      if (found == true) {
          System.out.println("[" + i + "," + j + "]");
      } else {
    	  visited[i][j] = false;  
      }
      return found;
  }
  
  private void clearVisited() {
      for(int i = 0; i < length; i++) {
        for(int j = 0; j < breadth; j++) {
            visited[i][j] = false;
        }
      }
  }
  
  private boolean isValidMoveTop(int i, int j, int nextCharIndex) {
      if (i - 1 < 0) return false;
      if (visited[i-1][j]) return false;
      //System.out.println("Search fir At char:" + toSearch.charAt(nextCharIndex) + " at row:" + (i-1) + " at col:" + j);
      //System.out.println("At char:" + ch[i-1][j]);
      if (ch[i-1][j] != toSearch.charAt(nextCharIndex)) return false;
      //System.out.println("Found char!");
      return true;
  }

  private boolean isValidMoveBottom(int i, int j, int nextCharIndex) {
      if (i + 1 >= length) return false;
      if (visited[i+1][j]) return false;
      if (ch[i+1][j] != toSearch.charAt(nextCharIndex)) return false;
      return true;
  }  
  
  private boolean isValidMoveLeft(int i, int j, int nextCharIndex) {
      if (j - 1 < 0) return false;
      if (visited[i][j-1]) return false;                  
      if (ch[i][j - 1] != toSearch.charAt(nextCharIndex)) return false;
      return true;
  }

  private boolean isValidMoveRight(int i, int j, int nextCharIndex) {
      if (j + 1 >= breadth) return false;
      if (visited[i][j+1]) return false;
      if (ch[i][j + 1] != toSearch.charAt(nextCharIndex)) return false;
      return true;
  }  
  
  public static void main(String[] args) {
    FindPaths findPaths  = new FindPaths();
    String str1 = "mayank";
    String str2 = "ayanaylgedxb";
    //String str2 = "swapnil";
    if (findPaths.searchString(str1)) {
        System.out.println("Found! match for " + str1);
    } else {
        System.out.println("Not Found match for " + str1);
    }
    
    if (findPaths.searchString(str2)) {
        System.out.println("Found! match for " + str2);
    } else {
        System.out.println("Not Found match for " + str2);
    }
  }
}