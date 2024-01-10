package test;

import java.util.List;

import model.GetMutterListLogic;
import model.Mutter;

public class TestGetMutterLogic {

	public static void main(String[] args) {
		GetMutterListLogic getmutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getmutterListLogic.execute();
		for (Mutter m : mutterList) {
			System.out.print(m.getId());
			System.out.print(m.getUserName());
			System.out.println(m.getText());
		}
	}

}
