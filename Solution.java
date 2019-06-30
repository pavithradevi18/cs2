package text;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.Date;

public class Solution {
public static void main(String[] args) {
		
		List<health> h=readFileFromtxt("input.txt");
		availablepolicy(h);
		expired(h);
		
	}
private static List<health> readFileFromtxt(String fileName)
{
	List<health> h1=new ArrayList<>();
	Path pathToFile=Paths.get(fileName);
	
	try(BufferedReader br=Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)){
		String line=br.readLine();
		while(line!=null)
		{
			String[] attributes=line.split(" ");
			health file=createList(attributes);
			h1.add(file);
			line=br.readLine();
		}
	} catch(IOException e)
	{
		e.printStackTrace(); //it prints the error class and error line
	}
	return h1;
}
private static health createList(String[] metadata)
{
	String policyno=metadata[0];
	String cost=metadata[1];
	String expdate=metadata[2];
	String addate=metadata[3];
	String disdate=metadata[4];
	String medspec=metadata[5];
	
	return new health(policyno,cost, expdate,addate,disdate,medspec);

}private static void availablepolicy (List<health> h2)
{
    String a="";
    String b="";

for(health i:h2)
{
	int sum=0;
	
String s1=i.getPolicyno().substring(0,2);

for(health j:h2) {
	
 a=j.getPolicyno();
 b=j.getMedspec();


if((a.contains(s1)) && (!b.contains("**"))) {
	 String ex=j.getCost();
	 int p=Integer.parseInt(ex);
	 j.setMedspec("**");
    sum+=p;
}
}
if(!b.contains("**"))
{
System.out.println(s1+" "+sum);
}


}


}
private static void expired(List<health> h3)
{
	for(health i:h3) 
	{
		try {
	String x=i.getDisdate(); 
	String y=i.getExpdate();
	SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy"); 
	Date d1=format.parse(x);
	Date d2=format.parse(y); 
	try {
	if(d1.after(d2))
	{
		String var=i.getPolicyno();
	    throw new MyException(var);
	}
		
	}
	catch(MyException e) {
		System.out.println(e);
	}
	
	}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
	}
}


}
