
class Node{
    int data;
    Node left,right;
    public Node(int element){
        data=element;
        left=null;
        right=null;
    }
}

class Dynamic_Stack{
    int size;
    int arr[];
    int top;
    public Dynamic_Stack(int data){
        size=data;
        arr=new int[size];
        top=-1;
    }
    public boolean empty(){
        if(top==-1){
            return true;
        }
        return false;
    }
    public boolean isfull(){
        if(top==size-1){
            return true;
        }
        return false;
    }
    public void top(){

        System.out.println(arr[top]);
    }
    public void push(int element){
        if(isfull()){
            increase_array_size();
        }
        top++;
        arr[top]=element;
    }
    public void increase_array_size(){
        int current_size=top+1;
        int array[]=new int[current_size*2];
        for(int i=0;i<current_size;i++){
            array[i]=arr[i];
        }
        arr=array;
        size=current_size*2;
    }
    public int pop(){
        if(!empty()){
            int val=arr[top];
            top--;
            return val;
            decrease_array_size();
        }
    }
    public void decrease_array_size(){
        int current_size=top+1;
        if(current_size<size/2){
            int array[]=new int[size/2];
            for(int i=0;i<size/2;i++){
                array[i]=arr[i];
            }
            arr=array;
            size=size/2;
        }
    }
    // function for evelute the postfix evalution 
    public evalute_postfix(int[] array,Dynamic_Stack stack){
    	for(int i=0;i<array.length;i++){
    		if(array[i]=='*'||array[i]=='/'||array[i]=='+'||array[i]=='-'){
    			// here we pop strt two elements in the stack and then evlute it and than again push back in the stack
    			int val1=stack.pop();
    			int val2=stack.pop();
    			if(array[i]=='*'){
    				stack.push(val1*val2);
    			}
    			if(array[i]=='/'){
    				stack.push(val1/val2);
    			}
    			if(array[i]=='+'){
    				stack.push(val1+val2);
    			}
    			if(array[i]=='-'){
    				stack.push(val1-val2);
    			}
    		}
    	}
    	return stack.top();
    }
    //function for create a binary tree for the postfix expression
    public create_tree(int[] array,Dynamic_Stack stack,Node root){
    	for(int i=0;i<array.length;i++){
    		if(array[i]=='*'||array[i]=='/'||array[i]=='+'||array[i]=='-'){
    			root=new Node(array[i]);
    			Node val1=stack.pop();
    			Node val2=stack.pop();
    			// here we pop strt two elements in the stack and then add one as aleft subtree or another one as a right subtree for the expression and after that we push back again our tree in the stack
    			t.right=val1;
    			t.left=val2;
    			stack.push(root);
    		}
    		//here the top element in the stcak is ouur binary tree than we prin it
    		
    		t=st.top();
    	}
    	return t;
    }
}