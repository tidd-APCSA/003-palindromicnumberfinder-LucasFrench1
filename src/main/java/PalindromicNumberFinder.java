public class PalindromicNumberFinder {
    private int num;

    // constructor
    public PalindromicNumberFinder(int num){
        this.num = num;
    }

    // accessor/getter method
    public int getNum(){
        return this.num;
    }

    // this method should find the next palindromic number
    public int searchForPalindromicNum(int num){
      String num_string = ""+num;
      
      if((num_string.charAt(0)+"").equals("-")){
        return Math.abs(num);
      }
      
      if(num_string.length()==1){
        if(num==9){
          return 2;
        }
        return 1;
      }
      if(num_string.length() % 2 == 0){ //is the length even?
        int halfStrLength = num_string.length()/2;
        int firstHalf = Integer.valueOf(num_string.substring(0, halfStrLength));
        int firstHalfReversed = Integer.valueOf(reverseNum(firstHalf));
        int secondHalf = Integer.valueOf(num_string.substring(halfStrLength));

        if(firstHalfReversed > secondHalf){
          return findPalindromeIfSecondHalfIsLess(num);
        }
        else if(testPalindromicNum(num)){
          int distance = (int)Math.pow(10, halfStrLength)+(int)Math.pow(10, halfStrLength-1);;
          if(testPalindromicNum(num+distance)){
            return distance;
          }
        }
        int distance = (int)Math.pow(10, halfStrLength) - secondHalf;
        return findPalindromeIfSecondHalfIsLess(num+distance)+distance;
      }

      int halfStrLength = (num_string.length()-1)/2;
      int firstHalf = Integer.valueOf(num_string.substring(0, halfStrLength));
      int firstHalfReversed = Integer.valueOf(reverseNum(firstHalf));
      int secondHalf = Integer.valueOf(num_string.substring(halfStrLength+1));

      if(firstHalfReversed > secondHalf){
        return firstHalfReversed - secondHalf;
      }
      else if(testPalindromicNum(num)){
        int distance = (int)Math.pow(10, halfStrLength);
        if(testPalindromicNum(num+distance)){
          return distance;
        }
      }
      int distance = (int)Math.pow(10, halfStrLength) - secondHalf;
      String newNumString = (""+(num+distance));
      return Integer.valueOf(reverseNum(Integer.valueOf(newNumString.substring(0, (newNumString.length()-1)/2)))) - Integer.valueOf(newNumString.substring((newNumString.length()-1)/2+1))+distance;

      //ignore this legacy code
      /*if(num_string.length() % 2 == 0){
        int halfStrLength = num_string.length()/2;
        int firstHalf = Integer.valueOf(num_string.substring(0, halfStrLength));
        int firstHalfReversed = Integer.valueOf(reverseNum(firstHalf));
        int secondHalf = Integer.valueOf(num_string.substring(halfStrLength));
        int secondHalfReversed = Integer.valueOf(reverseNum(secondHalf));

        if( firstHalfReversed > secondHalf){
          System.out.println(firstHalf+" "+ secondHalf);
          return firstHalfReversed - secondHalf;
        }
        else if(testPalindromicNum(num)){
          System.out.println("2");
          return (int)Math.pow(10, halfStrLength)+(int)Math.pow(10, halfStrLength-1);
        }
        System.out.println("3");
        return (int)(firstHalf+Math.pow(10, halfStrLength)+1) - secondHalfReversed;
      }
      int halfStrLength = (num_string.length()-1)/2;
      int firstHalf = Integer.valueOf(num_string.substring(0, halfStrLength));
      */
    }

    //this function is mostly unnecessary and kind of makes the code uglier
    private int findPalindromeIfSecondHalfIsLess(int num){
      String num_string = ""+num;

      int halfStrLength = num_string.length()/2;
      int firstHalf = Integer.valueOf(num_string.substring(0, halfStrLength));
      int firstHalfReversed = Integer.valueOf(reverseNum(firstHalf));
      int secondHalf = Integer.valueOf(num_string.substring(halfStrLength));

      return firstHalfReversed - secondHalf;
    }

    // this is a helper method for searchForPalindromicNum. It's purpose is to test if a number is actually a palindrome
    public boolean testPalindromicNum(int num){
      if(num == Integer.valueOf(reverseNum(num))){
        return true;
      }
      return false;
    }


    // this is a helper method for testPalindromicNum. It should reverse the number and return it.
    public String reverseNum(int num){
      String string_num = ""+num;
      String out = "";
      for(int i = string_num.length()-1; i >= 0; i--){
        out += string_num.charAt(i);
      }
      return out;
    }


    @Override
    public String toString(){
        return "You'd have to drive " + searchForPalindromicNum(this.num) + " miles";
    }
}
