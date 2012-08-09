package com.kyu.image.test;

import java.io.File;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

/**
 * @FileName : MimeMagicTest.java
 * @Project : sample_project
 * @Date : 2012. 8. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class MimeMagicTest  {
	private static String gifFile = "test_docs/test.gif";
	private static String pngFile = "E:\\test\\resize\\img\\test.png";
	private static String jpgFile = "test_docs/test.jpg";
	private static String textFile = "test_docs/test.txt";
	private static String word2KFile = "test_docs/test_word_2000.doc";
	private static String word95File = "test_docs/test_word_6.0_95.doc";
	private static String rtfFile = "test_docs/test.rtf";
	private static String excel2KFile = "test_docs/test_excel_2000.xls";
	private static String pdfFile = "test_docs/test.pdf";
	private static String psFile = "test_docs/test.ps";
	private static String javaClass12File = "test_docs/test_1.2.class";
	private static String javaClass13File = "test_docs/test_1.3.class";
	private static String javaClass14File = "test_docs/test_1.4.class";
	private static String mp3_128_44_jstereoFile = "test_docs/test_128_44_jstereo.mp3";
	private static String wavFile = "test_docs/test.wav";

	public static void main(String args[]) {
		MimeMagicTest test = new MimeMagicTest();

		test.testPNG();
	}

	// IMAGE TESTS

	public void testGIF() {
		System.out.print("\ntesting GIF image...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(gifFile), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testGIF()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testGIF(). message: " + e.getMessage());
		}
	}

	public void testPNG() {
		System.out.print("\ntesting PNG image...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(pngFile), true);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testPNG()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testPNG(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testPNG(). message: " + e.getMessage());
		}
	}

	public void testJPEG() {
		System.out.print("\ntesting JPEG image...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(jpgFile), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testJPEG()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testJPEG(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testJPEG(). message: " + e.getMessage());
		}
	}

	// DOCUMENT TESTS

	public void testText() {
		System.out.print("\ntesting Plain Text Document...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(textFile), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testText()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testText(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testText(). message: " + e.getMessage());
		}
	}

	public void testWord2K() {
		System.out.print("\ntesting Word 2000 Document...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(word2KFile), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testWord2K()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testWord2K(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testWord2K(). message: " + e.getMessage());
		}
	}

	public void testWord95() {
		System.out.print("\ntesting Word 95 Document...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(word95File), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testWord95()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testWord95(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testWord95(). message: " + e.getMessage());
		}
	}

	public void testRTF() {
		System.out.print("\ntesting RTF Document...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(rtfFile), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testRTF()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testRTF(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testRTF(). message: " + e.getMessage());
		}
	}

	public void testExcel2K() {
		System.out.print("\ntesting Excel 2000 Document...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(excel2KFile), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testExcel2K()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testExcel2K(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testExcel2K(). message: " + e.getMessage());
		}
	}

	// OTHER

	public void testPDF() {
		System.out.print("\ntesting PDF Document...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(pdfFile), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testPDF()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testPDF(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testPDF(). message: " + e.getMessage());
		}
	}

	public void testPostscript() {
		System.out.print("\ntesting Postscript Document...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(psFile), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testPostscript()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testPostscript(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testPostscript(). message: " + e.getMessage());
		}
	}

	public void testJavaClass12() {
		System.out.print("\ntesting Java Class File (v1.2)...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(javaClass12File), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testJavaClass12()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testJavaClass12(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testJavaClass12(). message: " + e.getMessage());
		}
	}

	public void testJavaClass13() {
		System.out.print("\ntesting Java Class File (v1.3)...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(javaClass13File), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testJavaClass13()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testJavaClass13(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testJavaClass13(). message: " + e.getMessage());
		}
	}

	public void testJavaClass14() {
		System.out.print("\ntesting Java Class File (v1.4)...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(javaClass14File), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testJavaClass14()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testJavaClass14(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testJavaClass14(). message: " + e.getMessage());
		}
	}

	public void testMP3() {
		System.out.print("\ntesting MPEG Layer 3...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(mp3_128_44_jstereoFile), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testMP3()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testMP3(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testMP3(). message: " + e.getMessage());
		}
	}

	public void testWave() {
		System.out.print("\ntesting WAVE...");
		try {
			MagicMatch match = Magic.getMagicMatch(new File(wavFile), true, false);
			if (match != null) {
			} else {
				System.out.print("System.out.printlned");
				System.out.println("no match in testWave()");
			}
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception in testWave(). message: " + e);
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("error in testWave(). message: " + e.getMessage());
		}
	}
}
