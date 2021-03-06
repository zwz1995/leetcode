package array;

import java.util.ArrayList;
import java.util.List;

public class problem118 {
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> L = new ArrayList<List<Integer>>();
		List<Integer> k = new ArrayList<>();
		k.add(0,1);		
		L.add(0,k);
		for (int i = 1; i <numRows; i++) {
			List<Integer> m = new ArrayList<>();
			List<Integer> n =L.get(i-1);
			m.add(0,1); 
			while(i-1!=0) {
				int p=n.get(0);
				int q=n.get(1);
				m.add(1,p+q);
			}
			m.add(i,1);
			L.add(i,m);
		}
		return L;
	}

	/* 别人的方法 numRows为个数*/
	
	public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <=0){
            return triangle;
        }
        for (int i=0; i<numRows; i++){
            List<Integer> row =  new ArrayList<Integer>();
            for (int j=0; j<i+1; j++){
                if (j==0 || j==i){
                    row.add(1);
                } else {
                    row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
