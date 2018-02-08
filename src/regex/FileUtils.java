package regex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtils {

	private File outFile;
	private FileWriter fw;
	private BufferedWriter bw;

	public FileUtils(String filename){
		setOutFile(filename);
		setFw();
		setBw();
	}

	/*
	 * Getters and Setter
	 */
	public File getOutFile() {
		return this.outFile;
	}
	public FileWriter getFw() {
		return fw;
	}
	public BufferedWriter getBw() {
		return bw;
	}

	public void setOutFile(String outFile) {
		this.outFile = new File(outFile);
	}
	public void setFw() {
		try {
			this.fw = new FileWriter(getOutFile());
		} catch (IOException ex) {
			System.out.println("Error: I/O exception: " + ex);
			System.exit(1);
		}
	}
	public void setBw() {
		this.bw = new BufferedWriter(getFw());
	}


	/*
	 * Writes the data to disk
	 */
	public void writeInFile(String value) {
        try {
            bw.write(value);
            bw.flush();
        } catch (IOException ex) {
            System.out.println("Error: I/O exception: " + ex);
            System.exit(1);
        }
	} // writeFile

    public void closeFileUtils() {
	    try {
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error: I/O exception: " + ex);
            System.exit(1);
        }
    }


} // class
