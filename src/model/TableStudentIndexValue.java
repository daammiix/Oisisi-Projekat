package model;

public class TableStudentIndexValue implements Comparable<TableStudentIndexValue> {

    private String indexStudent;
    private String smer;
    private int broj;
    private int godina;

    public TableStudentIndexValue(String index){
    	indexStudent = index;
    	String[] arrOfStr = index.split("-");
        smer = arrOfStr[0];
        broj = Integer.parseInt(arrOfStr[1]);
        godina = Integer.parseInt(arrOfStr[2]);
    }

    public String toString(){
        return indexStudent;
    }

    @Override
    public int compareTo(TableStudentIndexValue o) {
    	if(smer.compareTo(o.smer)>0){
    		return 1;
    	}
    	else if(smer.compareTo(o.smer)< 0) {
    		return -1;
    	}
    	else { //isti smer
    		if(godina > o.godina){
        		return 1;
        	}
        	else if(godina < o.godina) {
        		return -1;
        	}
        	else { //ista godina
        		if(broj > o.broj){
            		return 1;
            	}
            	else {
            		return -1;
            	}
        	}
    	}
    }
}
