package Algorithm;

import java.util.HashMap;

public class ����Ʈ�ٹ�_��ȿ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var hash = new HashMap<String,Integer>();

		int max = 0; // ���� ū value���� ã�� ���� ����
		int max2 = -10, max2_index=-10; // key���� ã�� ���� genre�迭�� plays�迭���� ���� ū ������ ã�� ���� ������
		int index = 0; // answer index
		int index2 = 0; // 2���� ���ھ��� ��� ���� ����� ����
		String key = "";
		String[] genres = {"classic", "pop", "classic", "pop", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int [] answer = {0,0,0,0};
		
		for(int i=0;i<genres.length;i++) {
			hash.put(genres[i], hash.getOrDefault(genres[i],0)+plays[i]); 
			//getOrDefault(a,b)
			//a���� key������ �ִٸ� value�� ��ȯ
			//���ٸ� a���� key��, b�� value������
		}
		
		for(int m = 0;m<4;m++) {
			
			for(String a : hash.keySet()) {
				if(max < hash.get(a)) {
					max = hash.get(a); //value�� ���� ū ���� max�� ���� 
					key = a;   		   //key���� ����
				}
			}
			
			hash.remove(key);
			
			max = 0;
			index2 = 0;
			for(int i=0;i<genres.length;i++) {
				if(index2 == 2) break;
				if(genres[i]==key && max2 < plays[i]) {
					max2 = plays[i];		// key���� ��ġ�� ��� ���� ū plays���� ������
					max2_index = i;	    // �׶��� �ε��� ���� ����.
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
