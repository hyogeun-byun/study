package Algorithm;

import java.util.HashMap;

public class 베스트앨범_변효근 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var hash = new HashMap<String,Integer>();

		int max = 0; // 가장 큰 value값을 찾기 위한 변수
		int max2 = -10, max2_index=-10; // key값을 찾은 이후 genre배열과 plays배열에서 가장 큰 값들을 찾기 위한 변수들
		int index = 0; // answer index
		int index2 = 0; // 2개의 숫자씩을 얻기 위해 사용한 변수
		String key = "";
		String[] genres = {"classic", "pop", "classic", "pop", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int [] answer = {0,0,0,0};
		
		for(int i=0;i<genres.length;i++) {
			hash.put(genres[i], hash.getOrDefault(genres[i],0)+plays[i]); 
			//getOrDefault(a,b)
			//a값이 key값으로 있다면 value값 반환
			//없다면 a값을 key값, b를 value값으로
		}
		
		for(int m = 0;m<4;m++) {
			
			for(String a : hash.keySet()) {
				if(max < hash.get(a)) {
					max = hash.get(a); //value가 제일 큰 값을 max에 저장 
					key = a;   		   //key값도 저장
				}
			}
			
			hash.remove(key);
			
			max = 0;
			index2 = 0;
			for(int i=0;i<genres.length;i++) {
				if(index2 == 2) break;
				if(genres[i]==key && max2 < plays[i]) {
					max2 = plays[i];		// key값이 일치할 경우 가장 큰 plays값을 가져옴
					max2_index = i;	    // 그때의 인덱스 값을 저장.
				}
				if(i==genres.length-1 && max2_index>=0) {
					answer[index++]= max2_index;
					genres[max2_index]="";
					i=-1;
					max2 = -10;
					max2_index=-10;
					index2++;
				}
			}
		}
		for(int m=0;m<4;m++)
			System.out.println(answer[m]);
	}

}
