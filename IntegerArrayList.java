import com.sun.deploy.security.SelectableSecurityManager;

public class IntegerArrayList implements IntegerList
{
    private int size;
    private Integer[] data;

    public IntegerArrayList()
    {
        size = 0;
        data = new Integer[10];
    }

    public void add(Integer val)
    {
        if(data.length <= size)
        {
            Integer[] biggerArray = new Integer[data.length*2];
            for (int i = 0; i<data.length; i++)
            {
                biggerArray[i] = data[i];
            }
            data = biggerArray;
        }
        data[size] = val;
        size++;
    }
    public void add(int index, Integer val)
    {
        if(data.length <= size)
        {
            Integer[] biggerArray = new Integer[data.length*2];
            for (int i = 0; i<data.length; i++)
            {
                biggerArray[i] = data[i];
            }
            data = biggerArray;
        }
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        else
        {
            for (int i = size; i >= index; i--)
            {
                data[i + 1] = data[i];
            }
            data[index] = val;
            size++;
        }

    }
    public void set(int index, Integer val)
    {
        data[index] = val;
    }
    public void clear()
    {
        size = 0;
    }
    public Integer remove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        else
        {
            for (int i = index; i<size-1; i++)
            {
                data [i] = data[i+1];
            }
            data[size-1] = 0;
            size--;
        }
        return null;
    }
    public Integer get(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        else
        {
            return data[index];
        }

    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public boolean contains(Integer val)
    {
        int num = 0;
        boolean contains = false;
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == val)
            {
                num++;
            }
        }
        if ( num > 0)
        {
            contains = true;
        }
        return contains;
    }
    public int indexOf(Integer val)
    {
        int index = -1;
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == val)
            {
                index = i;
                break;
            }
        }
        return index;
    }
    public boolean equals(List<Integer> other)
    {
        boolean equals = false;
        for (int i = 0; i < size; i ++)
        {
            if (data[i].equals(other.get(i)))
            {
                equals = true;
            }
            else
            {
                equals = false;
                break;
            }
        }
        return equals;
    }
    public String toString()
    {
        String result = " ";
        if (size == 0)
        {
            for (int i = 0; i<size-1; i++)
            {
                result += data[i] + ",";
            }
            return result;
        }
       else
       {
           result = "[";
           for (int i = 0; i<size-1; i++)
           {
               result += data[i] + ",";
           }
           result += data[size-1] + "]";
           return result;
       }

    }
}
