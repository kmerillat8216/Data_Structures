/// palindrome.java 
//
// fall 2025
// lab4b assignment
//
// Karissa.Merillat
//
// Use for paindrome.java

public class Palindrome {
    
    public static void main(String[] args) {

        //single call to test
        System.out.println( palindrome("racecar") ); //true
        System.out.println( palindrome("sass") ); //false

        //uncomment to test additional words
        /*
        String words[] = { "a", "racecar", "noon", "hannah", "abcba", "abbca", "nope", "ab" };

        for (int i = 0; i < words.length; i++) {

            if (palindrome(words[i]) == true)
                System.out.println( words[i] + " IS a palindrome");
            else
                System.out.println( words[i] + " IS NOT a palindrome");
        }
        */
        
    }// main

    // *** use StackCharArray and QueueCharArray here to determine Palindrome
    private static boolean palindrome(String word) {

        //assume status is true
        boolean status = true;

		// *** add code here
        StackCharArray st = new StackCharArray(100);
        QueueCharArray qu = new QueueCharArray(100);

        int i = 0;
      while (i < word.length())
      {
        st.push( word.charAt(i) );
        i++;
      }   
            
      System.out.println( st );

      int j = 0;
      while (j < word.length())
      {
        qu.add( word.charAt(j) );
        j++;
      }

      System.out.println( qu );
      
      while (st.empty() == false && status == true)
      {
        if (st.top() != qu.front())
            status = false;
        else
        {
             st.pop();
             qu.remove();
        }
      }

        return status;

        
    }// palindrome method

}//class
