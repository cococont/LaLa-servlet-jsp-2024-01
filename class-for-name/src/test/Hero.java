package test;

public class Hero {
	static {
		System.out.println("static初期化ブロック");
	}
	{
		System.out.println("インスタンス初期化ブロック");
	}
	public Hero() {
		System.out.println("コンストラクタ");
	}
}
