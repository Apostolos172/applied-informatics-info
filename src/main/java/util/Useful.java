package util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import architecture.Assistant;
import architecture.Associate;
import architecture.Dean;
import architecture.NormalProfessor;
import architecture.Professor;

public class Useful {

	public Useful() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean photoFileExists(String photoFileName, HttpServletRequest request, StringBuilder suffix) {
		String path = request.getServletContext().getRealPath( "/images/professors/"+photoFileName+".jpg" );
		File f = new File(path);
		boolean exists = f.exists();
		suffix.append(".jpg");
		if(!exists) {
			path = request.getServletContext().getRealPath( "/images/professors/"+photoFileName+".png" );
			f = new File(path);
			exists = f.exists();
			suffix.delete(0, suffix.length());
			suffix.append(".png");
		}
		return exists;
	}
	
	public static String getProfessorTypeAlias(String cat) {
		String catAlias = null;
		switch(cat) {
		  case "Καθηγητής":
			  catAlias = "professor";
			  break;
		  case "Επίκουρος καθηγητής":
			  catAlias = "assistant";
			  break;
		  case "Αναπληρωτής Καθηγητής":
			  catAlias = "associate";
			  break;
		  case "Κοσμήτορας":
			  catAlias = "dean";
			  break;
		  default:
		    // do nothing
		}
		return catAlias;
	}
	
	public static Professor getAppropriateProfessorObj(String cat, String firstName, String lastName, String phone, String email, HttpServletRequest request) {
		Professor tempProf = null;
		switch(cat) {
		  case "professor":
			  tempProf = new NormalProfessor(firstName, lastName, phone, email, request);
			  break;
		  case "associate":
			  tempProf = new Associate(firstName, lastName, phone, email, request);
			  break;
		  case "assistant":
			  tempProf = new Assistant(firstName, lastName, phone, email, request);
			  break;
		  case "dean":
			  tempProf = new Dean(firstName, lastName, phone, email, request);
			  break;
		  default:
		    // do nothing
		}
		return tempProf;
	}

	public static Professor getAppropriateProfessorObj(String cat, String fname, String lname, String phone,
			String email) {
		// TODO Auto-generated method stub
		Professor tempProf = null;
		switch(cat) {
		  case "professor":
			  tempProf = new NormalProfessor(fname, lname, phone, email );
			  break;
		  case "associate":
			  tempProf = new Associate(fname, lname, phone, email );
			  break;
		  case "assistant":
			  tempProf = new Assistant(fname, lname, phone, email );
			  break;
		  case "dean":
			  tempProf = new Dean(fname, lname, phone, email );
			  break;
		  default:
		    // do nothing
		}
		return tempProf;	}

}
