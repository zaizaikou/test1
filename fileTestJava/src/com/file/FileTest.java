package com.file;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class FileTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		File f = new File("D:\\javaTest\\javaFile.txt");
		FileInputStream fis = null;
		FileOutputStream fos = null;

		if(f.isFile()) {
			System.out.println("ファイルは既に存在です。");
			System.out.println("パス："+f.getAbsolutePath());
			System.out.println("読み書き："+f.canRead());
			System.out.println("ファイブ容量："+f.length());

			try {
				fis = new FileInputStream(f);

				byte[] bytes = new byte[1024];

				int data = 0;
				while((data = fis.read(bytes)) != -1) {
					String s = new String(bytes,0,data);
					System.out.println("ファイル中身です。");
					System.out.println(s);
				}

				fos = new FileOutputStream(f);
				String s = "java勉強\r\n";
				String s2 = "java勉強２";

				fos.write(s.getBytes());
				fos.write(s2.getBytes());

				System.out.println("書き込み以降：");

				System.out.println("パス："+f.getAbsolutePath());
				System.out.println("容量："+f.length());
				System.out.println("読み書き："+f.canRead());

				FileInputStream fis2 = new FileInputStream(f);

				int data2 = 0;
				byte[] byte2 = new byte[1024];

				while((data2 = fis2.read(byte2))!=-1) {

					String s3 = new String(byte2,0,data2);
					System.out.println("書き込み以後の中身：");
					System.out.println(s3);
				}




			}catch(Exception e) {
				e.printStackTrace();
			}




		}else {
			try {
				f.createNewFile();
			}catch(Exception e){
				e.printStackTrace();

			}

		}


		File dt = new File("D:\\javaTest\\javaDirec");

		if(dt.isDirectory()) {
			System.out.println("フォルダが既に存在");

			File list[] = dt.listFiles();

			for(int i=0;i<list.length;i++) {
				System.out.println("ファイル名："+list[i].getName());

			}

		}else {

			try {
				dt.mkdir();

			}catch(Exception e) {
				e.printStackTrace();
			}
		}




	}

}
