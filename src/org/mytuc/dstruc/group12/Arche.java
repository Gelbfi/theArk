package com.assignment_2;



public class Arche {
   
	public String name;
    public MyLinkedList<Animals>  OnBoardList;
    
	public Arche() {
		
		 this.OnBoardList=new MyLinkedList<Animals>();
		 
	}
	
	
	public void AddAnimals(Animals a1)
	{
		OnBoardList.add(a1);
		System.out.println(a1.getType()+" "+a1.getName()+" on board ");
		return ;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	public void insertion_Sort() {
		
		int i,j;
		int length=this.OnBoardList.size();
		
       
		//Insertion sorting base on switching Node data but not pointer.
		for(i=0;i<length-1;i++)
		{
			for (j=i+1;j>0;j--)
			{
				if(OnBoardList.get(j-1).getFodder()<=OnBoardList.get(j).getFodder()) break;
				Animals Temp= new Animals(null,null,null,0,0);
				Temp=this.OnBoardList.get(j);
				this.OnBoardList.set(j,this.OnBoardList.get(j-1));
				this.OnBoardList.set(j-1,Temp);
				
			}
		}
	}
				

	
	
	public void show_list()
	{  
		for(int i=0;i<this.OnBoardList.size();i++) {
		System.out.println(this.OnBoardList.get(i));
		}
		
	}
	
	
}
