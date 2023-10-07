

import java.util.*;
import java.io.*;
public class Lists {
    public static int bsf(int arr[],int target)
    {
        int ans=-1;
        int s=0,e=arr.length-1;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(arr[mid]==target)
            {
                ans=arr[mid];
                break;
            }
            else if(arr[mid]<target)
            {
                ans=arr[mid];
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }
        return ans;
    }
    public static int first(int arr[],int target)
    {
        int ans=-1;
        int s=0,e=arr.length-1;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(arr[mid]==target)
            {
                if(mid>0 && arr[mid]>arr[mid-1])
                {
                    ans=mid;
                    break;
                }
                else if(mid==0)
                {
                    ans=mid;
                    break;
                }
                else
                {
                    ans=mid;
                    e=mid-1;
                }
            }
            else if(arr[mid]>target)
            {
                e=mid-1;
            }
            else s=mid+1;
        }
        return ans;
    }
    public static int Sqrt(int n)
    {
        int ans=-1;
        if(n<=1)
            return n;
        int s=1,e=n;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(mid*mid==n)
                return mid;
            else if(mid*mid>n)
            {
                e=mid-1;
            }
            else {
                ans=mid;
                s=mid+1;
            }
        }
        return ans;
    }
    public static void selectionSort(String [] arr,int n)
    {
        int i,j;
        for(i=0;i<n;i++)
        {
            int idx=i;
            for(j=i+1;j<n;j++)
            {
                if(arr[j].compareTo(arr[idx])<=0)
                {
                    idx=j;
                }
            }
            //swapping the values at idx and i
            String temp=arr[i];
            arr[i]=arr[idx];
            arr[idx]=temp;
        }
    }
    public static void selectionSortLen(String [] arr,int n)
    {
        int i,j;
        for(i=0;i<n;i++)
        {
            int idx=i;
            for(j=i+1;j<n;j++)
            {
                if(arr[j].length()<arr[idx].length())
                {
                    idx=j;
                }
            }
            //swapping the values at idx and i
            String temp=arr[i];
            arr[i]=arr[idx];
            arr[idx]=temp;
        }
    }
    public static void insertionSort(int[] arr,int n)
    {
        int i,j;
        for(i=1;i<n;i++)
        {
            int key=arr[i];
            for(j=i-1;j>=0;j--)
            {
                if(arr[j]<key)
                    break;
                arr[j+1]=arr[j];
            }
            arr[j+1]=key;
        }
    }
    public static void merge(int s,int mid,int e,int[] arr)
    {
        int l1=mid-s+1;
        int l2=e-mid;
        int[] l=new int[l1];
        int[] r=new int[l2];
        int i,j;
        for(i=0;i<l1;i++)
        {
            l[i]=arr[s+i];
        }
        for(i=0;i<l2;i++)
        {
            r[i]=arr[mid+1+i];
        }
        int p=0,q=0;
        int k=s;
        while(p<l1 && q<l2)
        {
            if(l[p]<=r[q])
            {
                arr[k]=l[p];
                p++;
            }
            else {
                arr[k]=r[q];
                q++;
            }
            k++;
        }
        while(p<l1)
        {
            arr[k]=l[p];
            k++;
            p++;
        }
        while(q<l2)
        {
            arr[k]=r[q];
            k++;
            q++;
        }
    }
    public static void mergeSort(int s,int e,int[] arr)
    {

        if(s<e)
        {
            int mid=s+(e-s)/2;
            mergeSort(s,mid,arr);
            mergeSort(mid+1,e,arr);
            merge(s,mid,e,arr);
        }
    }
    public static boolean contains(int x,int[] arr)
    {
        int i,n=arr.length;
        for(i=0;i<n;i++)
        {
            if(arr[i]==x)
                return true;
        }
        return false;
    }
    public static int partition(int s,int e,int[] arr)
    {
        int pivot=arr[e];
        int p=s;
        int i;
        for(i=s;i<e;i++)
        {
            if(arr[i]<pivot) {
                int temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                p++;
            }
        }
        int temp=arr[e];
        arr[e]=arr[p];
        arr[p]=temp;
        return p;
    }
    public static void quickSort(int s,int e,int[] arr)
    {
        if(s<e)
        {
            int p=partition(s,e,arr);
            quickSort(s,p-1,arr);
            quickSort(p+1,e,arr);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        int i,j;
        for(i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println("array before sorting");
        for(i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        quickSort(0,n-1,arr);
        System.out.println("array after sorting");
        for(i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    //t(n)=O(10*n^0)~O(n^0)~O(1)
}
