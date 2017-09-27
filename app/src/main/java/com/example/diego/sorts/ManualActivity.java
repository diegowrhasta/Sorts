package com.example.diego.sorts;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManualActivity extends AppCompatActivity {
    public int n,i=0;
    public int v[];
    public Button bt1,bt2;
    public EditText et1,et2;
    public TextView dialogo;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
        bt2=(Button)findViewById(R.id.bt2);
        bt1=(Button)findViewById(R.id.bt1);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);
        dialogo=(TextView)dialog.findViewById(R.id.dialog);
    }
    public void setTamanio(View view)
    {
        String aux=et1.getText()+"";
        n=Integer.parseInt(aux);
        bt1.setEnabled(false);
        bt2.setEnabled(true);
        et2.setEnabled(true);
        et1.setEnabled(false);
        v=new int[n];
    }
    public void AddVector(View view)
    {
        String aux=et2.getText()+"";
        et2.setText("");
       if(i!=(n-1))
        {
            v[i]=Integer.parseInt(aux);
            i++;
        }
        else
       {
           v[i]=Integer.parseInt(aux);
           i++;
           Toast.makeText(this, "El vector ya se llenó", Toast.LENGTH_SHORT).show();
           bt2.setEnabled(false);
           et2.setEnabled(false);
       }
    }
    public void showVector(View view)
    {
        try {
            String aux = "";
            for (int i = 0;i<n;i++)
            {
                aux=aux+v[i]+",";
            }
            dialogo.setTextSize(30);
            dialogo.setText(aux);
            dialog.show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "No se puede mostrar el vector", Toast.LENGTH_SHORT).show();
        }
    }
    public void InsertionSort(View view)
    {
        long startTime = System.currentTimeMillis();
        int temp;
        for (int i = 1; i < n; i++) {
            for(int j = i ; j > 0 ; j--){
                if(v[j] < v[j-1]){
                    temp = v[j];
                    v[j] = v[j-1];
                    v[j-1] = temp;
                }
            }
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        String aux=""+elapsedTime;
        Toast.makeText(this, "Tiempo del algoritmo: "+aux+" Ms", Toast.LENGTH_SHORT).show();
    }
    public void SelectionSort(View view)
    {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < n; j++)
                if (v[j] < v[index])
                    index = j;

            int smallerNumber = v[index];
            v[index] = v[i];
            v[i] = smallerNumber;
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        String aux=""+elapsedTime;
        Toast.makeText(this, "Tiempo del algoritmo: "+aux+" Ms", Toast.LENGTH_SHORT).show();
    }

    // <-- MERGE SORT -->
    public void MergeSort(View view)
    {
        long startTime = System.currentTimeMillis();
        sort(v, 0, n-1);
        long elapsedTime = System.currentTimeMillis() - startTime;
        String aux=""+elapsedTime;
        Toast.makeText(this, "Tiempo del algoritmo: "+aux+" Ms", Toast.LENGTH_SHORT).show();
    }
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    // <-- MERGE SORT -->
    public void ShellSort(View view)
    {
        long startTime = System.currentTimeMillis();
       /* function to sort arr using shellSort */
            // Start with a big gap, then reduce the gap
            for (int gap = n/2; gap > 0; gap /= 2)
            {
                // Do a gapped insertion sort for this gap size.
                // The first gap elements a[0..gap-1] are already
                // in gapped order keep adding one more element
                // until the entire array is gap sorted
                for (int i = gap; i < n; i += 1)
                {
                    // add a[i] to the elements that have been gap
                    // sorted save a[i] in temp and make a hole at
                    // position i
                    int temp = v[i];

                    // shift earlier gap-sorted elements up until
                    // the correct location for a[i] is found
                    int j;
                    for (j = i; j >= gap && v[j - gap] > temp; j -= gap)
                        v[j] = v[j - gap];

                    // put temp (the original a[i]) in its correct
                    // location
                    v[j] = temp;
                }
            }
        long elapsedTime = System.currentTimeMillis() - startTime;
        String aux=""+elapsedTime;
        Toast.makeText(this, "Tiempo del algoritmo: "+aux+" Ms", Toast.LENGTH_SHORT).show();
    }
}
