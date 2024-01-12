package util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsExistsIdLogic;

public class MayValidator {
	public List<String> check(Employee emp) {
		List<String> errors = new ArrayList<>();
		String id = emp.getId();
		if (id == null || id.length() == 0) {
			errors.add("IDが未入力です");
		} else if (!id.matches("^EMP[0-9]{3}$")) {
			errors.add("IDの形式が不正です");
		}
		IsExistsIdLogic isExistsIdLogic = new IsExistsIdLogic();
		if (isExistsIdLogic.execute(id)) {
			errors.add("IDが重複しています");
		}
		String name = emp.getName();
		if (name == null || name.length() == 0) {
			errors.add("名前が未入力です");
		} else if (name.length() > 20) {
			errors.add("名前は20文字以内で記入してください");
		}
		int age = emp.getAge();
		if (age < 18 || age > 80) {
			errors.add("年齢が不正です");
		}
		return errors;
	}
}