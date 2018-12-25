package createdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
	private String url_file;
	private File file;
	BufferedReader bf;
	public ReadFile() {
	
	}
	public void setlink(String url) {
		this.url_file = url;
	}
	public ArrayList<String> readf() throws IOException{
		ArrayList<String> res = new ArrayList<String>();
		file = new File(this.url_file);
		
		try {
			bf = new BufferedReader(new FileReader(url_file));
			String tmp = bf.readLine();
			while(tmp != null){
				res.add(tmp);
				tmp =bf.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	public long readind() throws IOException{
		long res =0;
		file = new File(this.url_file);
		
		try {
			bf = new BufferedReader(new FileReader(url_file));
			String tmp = bf.readLine();
			while(tmp != null){
				res = Long.parseLong(tmp);
				tmp =bf.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bf.close();
		return res;
	}
}
