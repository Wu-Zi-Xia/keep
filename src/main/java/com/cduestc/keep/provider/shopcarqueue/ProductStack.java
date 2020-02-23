package com.cduestc.keep.provider.shopcarqueue;

import java.lang.reflect.Array;
//运用了单例设计模式
public class ProductStack<T> {
    private int maxSize;
    private int currentSize;// 当前栈中的有效值个数
    private T[] stack;
    private int top = -1;
    //静态常量
    private volatile static ProductStack INSTANCE;
    //创建栈的构造器私有化
    private ProductStack(int arrMaxSize,Class<T> componentType) {
        maxSize = arrMaxSize;
        stack = (T[]) Array.newInstance(componentType,arrMaxSize);
        top = -1; //栈顶指针
    }
    public ProductStack() {

    }
    //提供公共外部接口访问，调用此方法的时候才会实例化当前对象，解决线程安全问题,解决效率问题
    public ProductStack getInstance(Class<T> componentType, int maxSize)
    {
        if(INSTANCE==null)
        {
            synchronized(ProductStack.class)
            {
                if(INSTANCE==null)
                {
                    INSTANCE=new ProductStack(maxSize,componentType);
                }
            }
        }
        return INSTANCE;
    }

    public void push(T temp){
        if(top==maxSize-1){//判断栈是否满
            return;
        }
      top++;
      stack[top]=temp;
      currentSize++;
    }

public T[] getStack(){
        return stack;
}
public T pop(){
      T temp=stack[top];
      top--;
      currentSize--;
      return temp;
}
    public int getMaxSize() {
        return maxSize;
    }


    public T[] getArr() {
        return stack;
    }
public int getCurrentSize(){
        return this.currentSize;
}

}
