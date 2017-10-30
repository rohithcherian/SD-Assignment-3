package com.uh.cosc4353.homework3;

import java.util.Scanner;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

//Comparable Function
public class Main implements Comparable{

    public int compareTo(Object arg0) {
		return 0;
	}
    //Binary Search for Strings using Comparable
    public static <T extends Comparable<T>> boolean binarySearchString(T key, T[] list, int size)
    {
        
         int beginning = 0;
         int end = size - 1;
          
         while(end >= beginning) {
             int middle = (beginning + end) / 2;
             //compares objects to the key
             int compare = key.compareTo(list[middle]);
             if(compare == 0) {
            	 //returns true if there is a match
                 return true;
             }
             else if(compare > 0) {
            	 beginning = middle + 1;
             }
             else if(compare < 0) {
            	 end = middle - 1;
             }
        }
          return false;
    }
	
	//Binary Search For Integers
    public static boolean binarySearchInteger(double input, int[] list, int size)
    {
        
         int beginning = 0;
         int end = size - 1;
          
         while(end >= beginning) {
             int middle = (beginning + end) / 2;
             if(list[middle] == input) {
            	 //returns true if key is found
                 return true;
             }
             else if(list[middle] < input) {
            	 beginning = middle + 1;
             }
             else if(list[middle] > input) {
            	 end = middle - 1;
             }
        }
    	 //returns false if key is not found
          return false;
    }
	
	public static void main(String[] args)
	{
		
		CommandLineParser parseUserInputs = new BasicParser();
		Options entryType = new Options();
		Option typeInput = new Option("t", "type", true, " “i” for integer and “s” for string ");
		Option keyInput = new Option("k", "key", true, " “i” for integer and “s” for string ");
		Option listInput = new Option("l", "list", true, " “i” for integer and “s” for string ");
		listInput.setArgs(500);
		entryType.addOption(typeInput);
		entryType.addOption(keyInput);
		entryType.addOption(listInput);

		try {
			CommandLine parserFromCMD = parseUserInputs.parse(entryType, args);

				//Getting argument values
				String typetoString = parserFromCMD.getOptionValue("type");
				String keyToString = parserFromCMD.getOptionValue("key");
				String[] listToString = parserFromCMD.getOptionValues("list");
				char intergerOrStringUserInput = typetoString.charAt(0);

				switch(intergerOrStringUserInput) {
				//If user requests to input with integers
				case 'i': 
					int[] arrayIntegerList = new int[listToString.length];
					for (int i =0; i< listToString.length; i++)
					{
						arrayIntegerList[i] = Integer.parseInt(listToString[i]);
					}
					int keyPass = Integer.parseInt(keyToString);
					//Does binary search with user input of integers to find key in user's list of integers
					boolean integerKeyFound = binarySearchInteger( keyPass, arrayIntegerList, arrayIntegerList.length);
					 if (integerKeyFound == true) {
				            System.out.print("1");
				        }else{
				            System.out.print("0");
				        }
					
					
					break;
				//If user does not request to input with integer, which by default is string
				default:
					//Does binary search with user input of strings to find key in user's list of string values
					boolean stringKeyFound =binarySearchString(keyToString, listToString, listToString.length);
				    if (stringKeyFound == true) {
			            System.out.print("1");
			        }else{
			            System.out.print("0");
			        }
					break;
				}
				

		} catch (ParseException e) {
			System.out.print("There is an error.");
		}

	}
	

}
