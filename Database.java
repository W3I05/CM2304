import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class Database {
	
	String filePath;
	Scanner fileReader;
	
	
	public Database()
	{
		
	}
	
	/*
	 * Initialises the database
	 * @param path String The file path of the database
	 * @return boolean Returns true if the database file could be found and false if not
	 */
	public boolean initDatabase(String path)
	{
		
		filePath = path;
		
		try 
		{
			fileReader = new Scanner( new File(filePath));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	/*
	 * Inserts a new user into the database
	 * @param fName String Users first name
	 * @param lName String Users last name
	 * @param email	String Users email
	 * @param number String Users number
	 * @param password String Users password
	 * @param userID String Users ID
	 * @return boolean Returns true if the user was successfully inserted and false otherwise
	 */
	public boolean insertUser(String fName, String lName, String email, String number, String password, String userID)
	{
		fileReader.close();
		
		PrintWriter fileWriter = null;
		try 
		{
			fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		fileWriter.println(fName+","+lName+","+email+","+number+","+password+","+userID+";");
		fileWriter.close();
		
		resetFileReader();
		return true;
	}
	
	/*
	 * Deletes user from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return boolean Returns true if user was found and deleted and false otherwise
	 */
	public boolean deleteUser(String searchAttribute, String searchValue)
	{
		
		int attribute = 0;
		
		if(searchAttribute.compareToIgnoreCase("first name") == 0)
		{
			attribute = 0;
		}
		else if(searchAttribute.compareToIgnoreCase("last name") == 0)
		{
			attribute = 1;
		}
		else if(searchAttribute.compareToIgnoreCase("email") == 0)
		{
			attribute = 2;
		}
		else if(searchAttribute.compareToIgnoreCase("number") == 0)
		{
			attribute = 3;
		}
		else if(searchAttribute.compareToIgnoreCase("password") == 0)
		{
			attribute = 4;
		}
		else if(searchAttribute.compareToIgnoreCase("userID") == 0)
		{
			attribute = 5;
		}
		
		boolean found = false;
		int lineNo = 0;
		int deleteNo = 0;
		int lineCount = 0;
		while(fileReader.hasNext())
		{
			
			int commaCount = 0;
			String line = fileReader.nextLine();
			lineCount++;
			String word = "";
			for(int i=0; i < line.length(); i++)
			{
				if(line.charAt(i) == ',' || line.charAt(i) == ';')
				{
					
					if(attribute == commaCount)
					{
						
						if(word.compareToIgnoreCase(searchValue) == 0)
						{
							found = true;
							deleteNo = lineNo;
							
						}
					}
	
					word = "";
					commaCount++;
				}
				else
				{
					word += line.charAt(i);
				}
				
				
				
			}
			
			lineNo++;
		}
		
		if(!found)
			return false;
	
		
	
		
		String[] lines = new String[lineCount-1];
		int count = 0;
		int linesIn = 0;
		
		resetFileReader();
		while(fileReader.hasNext() && count != lineCount)
		{
			String line = fileReader.nextLine();
			if(count != deleteNo)
			{
				lines[linesIn] = line;
				linesIn++;
				System.out.println(lines[linesIn-1]);
			}
			
			count++;
		}
		
		fileReader.close();
		
		PrintWriter writer = null;
		try
		{
			writer = new PrintWriter(filePath, "UTF-8");
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		for(int i=0; i < lineCount-1; i++)
		{
			writer.println(lines[i]);
		}
		
		writer.close();
		resetFileReader();
		
		return true;
	}
	
	/*
	 * Gets users first name from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String Returns the first name if found or strings of "" if not found
	 */
	public String getUserFirstName(String searchAttribute, String searchValue)
	{
		String[] userInfo = getUser(searchAttribute, searchValue);
		return userInfo[0];
	}
	
	/*
	 * Gets users last name from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String Returns the last name if found or strings of "" if not found
	 */
	public String getUserLastName(String searchAttribute, String searchValue)
	{
		String[] userInfo = getUser(searchAttribute, searchValue);
		return userInfo[1];
	}
	
	/*
	 * Gets users email from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String Returns the users email if found or strings of "" if not found
	 */
	public String getUserEmail(String searchAttribute, String searchValue)
	{
		String[] userInfo = getUser(searchAttribute, searchValue);
		return userInfo[2];
	}
	
	/*
	 * Gets users number from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String Returns the users number if found or strings of "" if not found
	 */
	public String getUserNumber(String searchAttribute, String searchValue)
	{
		String[] userInfo = getUser(searchAttribute, searchValue);
		return userInfo[3];
	}
	
	/*
	 * Gets users password from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String Returns the password if found or strings of "" if not found
	 */
	public String getUserPassword(String searchAttribute, String searchValue)
	{
		String[] userInfo = getUser(searchAttribute, searchValue);
		return userInfo[4];
	}
	
	/*
	 * Gets users ID from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String Returns the ID if found or strings of "" if not found
	 */
	public String getUserID(String searchAttribute, String searchValue)
	{
		String[] userInfo = getUser(searchAttribute, searchValue);
		return userInfo[5];
	}
	
	/*
	 * Gets all user information from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String[] Returns an array of strings containing the information if found or strings of "" if not found
	 * [0] = first name; [1] = last name; [2] = email; [3] = number; [4] = password; [5] = userID
	 */
	public String[] getUser(String searchAttribute, String searchValue)
	{
		String[] user = new String[6];
		
		int attribute = 0;
		
		if(searchAttribute.compareToIgnoreCase("first name") == 0)
		{
			attribute = 0;
		}
		else if(searchAttribute.compareToIgnoreCase("last name") == 0)
		{
			attribute = 1;
		}
		else if(searchAttribute.compareToIgnoreCase("email") == 0)
		{
			attribute = 2;
		}
		else if(searchAttribute.compareToIgnoreCase("number") == 0)
		{
			attribute = 3;
		}
		else if(searchAttribute.compareToIgnoreCase("password") == 0)
		{
			attribute = 4;
		}
		else if(searchAttribute.compareToIgnoreCase("userID") == 0)
		{
			attribute = 5;
		}
		
		boolean found = false;
		while(fileReader.hasNext() && !found)
		{
			
			int commaCount = 0;
			String line = fileReader.nextLine();
			String word = "";
			for(int i=0; i < line.length(); i++)
			{
				if(line.charAt(i) == ',' || line.charAt(i) == ';')
				{
					
					if(attribute == commaCount)
					{
						
						if(word.compareToIgnoreCase(searchValue) == 0)
						{
							found = true;
						}
					}
					
					user[commaCount] = word;
					word = "";
					commaCount++;
				}
				else
				{
					word += line.charAt(i);
				}
				
				
				
			}

			
		}
		
		if(!found)
		{
			for(int i=0; i < 6; i++)
				user[i] = "";
		}
		
		resetFileReader();
		
		return user;
	}
	
	/*
	 * Gets modules name from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String Returns the module name if found or strings of "" if not found
	 */
	public String getModuleName(String searchAttribute, String searchValue)
	{
		String[] moduleInfo = getModule(searchAttribute, searchValue);
		return moduleInfo[0];
	}
	
	/*
	 * Gets module code name from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String Returns the module code if found or strings of "" if not found
	 */
	public String getModuleCode(String searchAttribute, String searchValue)
	{
		String[] moduleInfo = getModule(searchAttribute, searchValue);
		return moduleInfo[1];
	}
	
	/*
	 * Gets module credits from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return int Returns the module credits and -1 if not found
	 */
	public int getModuleCredits(String searchAttribute, String searchValue)
	{
		String[] moduleInfo = getModule(searchAttribute, searchValue);
		return Integer.parseInt(moduleInfo[2]);
	}
	
	/*
	 * Gets modules user roles from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String Returns the modules user roles if found or strings of "" if not found
	 */
	public String getModuleUserRole(String searchAttribute, String searchValue)
	{
		String[] moduleInfo = getModule(searchAttribute, searchValue);
		return moduleInfo[3];
	}
	
	/*
	 * Gets number of courseworks for a module from the database if the search term matches the search attribute
	 * eg. module name = Database Systems
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return int Returns the number of courseworks and -1 if not found
	 */
	public int getNumCoursework(String searchAttribute, String searchValue)
	{
		String[] moduleInfo = getModule(searchAttribute, searchValue);
		return Integer.parseInt(moduleInfo[4]);
	}
	
	/*
	 * Gets number of exams for a module from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return int Returns the number of exams and -1 if not found
	 */
	public int getNumExams(String searchAttribute, String searchValue)
	{
		String[] moduleInfo = getModule(searchAttribute, searchValue);
		return Integer.parseInt(moduleInfo[5]);
	}
	
	
	/*
	 * Gets whether a module has exams from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return boolean Returns true if module has exam or false otherwise
	 */
	public boolean getModuleHasExam(String searchAttribute, String searchValue)
	{
		String[] moduleInfo = getModule(searchAttribute, searchValue);
		if(moduleInfo[5].compareToIgnoreCase("true") == 0)
			return true;
		
		return false;
	}
	
	/*
	 * Gets whether a module has coursework from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return  boolean Returns true if module has coursework or false otherwise
	 */
	public boolean getModuleHasCoursework(String searchAttribute, String searchValue)
	{
		String[] moduleInfo = getModule(searchAttribute, searchValue);
		if(moduleInfo[6].compareToIgnoreCase("true") == 0)
			return true;
		
		return false;
	}
	
	/*
	 * Gets module task deadline from the database if the search term matches the search attribute
	 * eg. module name = Database Systems
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String Returns the module task deadline if found or strings of "" if not found
	 */
	public String getModuleTaskDeadline(String searchAttribute, String searchValue)
	{
		String[] moduleInfo = getModule(searchAttribute, searchValue);
		return moduleInfo[8];
	}
	

	
	/*
	 * Gets all module information from the database if the search term matches the search attribute
	 * eg. first name = Bob
	 * 
	 * @param searchAttribute String The attribute you're searching
	 * @param searchValue String The value you're searching the attribute for
	 * @return String[] Returns an array of strings containing the information if found or strings of "" if not found
	 * [0] = module name; [1] = module code; [2] = credits; [3] = user role; [4] = num coursework; [5] = num exmas
	 * [6] = exam paper; [7] = coursework; [8] = task deadline
	 */
	public String[] getModule(String searchAttribute, String searchValue)
	{
		String[] module = new String[9];
		
		int attribute = 0;
		
		if(searchAttribute.compareToIgnoreCase("module name") == 0)
		{
			attribute = 0;
		}
		else if(searchAttribute.compareToIgnoreCase("module code") == 0)
		{
			attribute = 1;
		}
		else if(searchAttribute.compareToIgnoreCase("credits") == 0)
		{
			attribute = 2;
		}
		else if(searchAttribute.compareToIgnoreCase("user role") == 0)
		{
			attribute = 3;
		}
		else if(searchAttribute.compareToIgnoreCase("num coursework") == 0)
		{
			attribute = 4;
		}
		else if(searchAttribute.compareToIgnoreCase("num exams") == 0)
		{
			attribute = 5;
		}
		else if(searchAttribute.compareToIgnoreCase("exam paper") == 0)
		{
			attribute = 6;
		}
		else if(searchAttribute.compareToIgnoreCase("coursework") == 0)
		{
			attribute = 7;
		}		
		else if(searchAttribute.compareToIgnoreCase("task deadline") == 0)
		{
			attribute = 8;
		}
		
		boolean found = false;
		while(fileReader.hasNext() && !found)
		{
			
			int commaCount = 0;
			String line = fileReader.nextLine();
			String word = "";
			for(int i=0; i < line.length(); i++)
			{
				if(line.charAt(i) == ',' || line.charAt(i) == ';')
				{
					
					if(attribute == commaCount)
					{
						
						if(word.compareToIgnoreCase(searchValue) == 0)
						{
							found = true;
						}
					}
					
					module[commaCount] = word;
					word = "";
					commaCount++;
				}
				else
				{
					word += line.charAt(i);
				}
				
				
				
			}

			
		}
		
		if(!found)
		{
			for(int i=0; i < 9; i++)
				module[i] = "";
		}
		
		resetFileReader();
		
		return module;
	}
	
	
	/*
	 * Resets the file reader so that the file can be read again
	 * (I couldn't get the normal reset function on the Scanner to work)
	 */
	public void resetFileReader()
	{
		fileReader.close();
		try 
		{
			fileReader = new Scanner( new File(filePath));
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Closes all open I/O objects
	 * MUST be called when database is finished being used
	 */
	public void close()
	{
		fileReader.close();
	}
	

	public static void main(String[] args)
	{
		Database d = new Database();
		d.initDatabase("users.txt");
		//d.insertUser("Simon", "Titcomb", "LOLNOPE@nah.com", "2345678986", "nahmate", "TitS");
		//d.insertUser("Aly", "Sheriff", "kingtut@pharoahpower.com", "11111", "egyptrules", "Tut");
		//d.insertUser("Mez", "Gangbanger", "kingofrape@ianwatkins.com", "5678987", "kids", "Kids101");
		String a = d.getUserFirstName("userID", "TitS");
		String b = d.getUserPassword("email", "kingtut@pharoahpower.com");
		System.out.println(a);
		System.out.println(b);
		String mez = d.getUserEmail("first name", "mez");
		System.out.println(mez);
		System.out.println(d.deleteUser("userID","Tut"));
		
		d.close();
		
		System.out.println("Completed.");

	}

}
