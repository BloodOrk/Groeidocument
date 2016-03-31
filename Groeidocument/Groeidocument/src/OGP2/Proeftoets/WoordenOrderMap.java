package OGP2.Proeftoets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WoordenOrderMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WoordenOrderMap();
	}

	public WoordenOrderMap() {
		List<String> list = new ArrayList<String>();
		list.add("asd");
		list.add("asdasd");
		list.add("wsd");
		list.add("12");
		list.add("qwewqqwe");
		list.add("weeeerf");
		list.add("d");
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

		for (String s : list) {
			List<String> orderList = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).length() == s.length())
					orderList.add(list.get(i));
			}
			map.put(s.length(), orderList);
		}

		System.out.println(map);

	}
}
