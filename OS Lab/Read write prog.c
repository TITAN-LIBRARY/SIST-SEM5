    #include<stdio.h>

    void main()
    {
        typedef int semaphore;
        semaphore sread = 0, swrite =0;
        int ch, r=0;
        // clrscr();
        printf("Readers Writers program\n");

        do {
            printf("\nMENU");
            printf("\n\t 1. Read from file");
            printf("\n\t 2. Write to the file ");
            printf("\n\t 3. Exit reader");
            printf("\n\t 4/ Exit Writer");
            printf("\n\t 5. Status of the file");
            printf("\n\t 6. Exit");
            printf("\nEnter your Choice");
            scanf("%d", &ch);
            switch(ch)
            {
            case 1:
                if (swrite == 1)
                {
                    sread = 1;
                    r++;
                    printf("\nReader %d reads the file \n", r);
                }
                else
                    printf("\nCannot read while writes to file\n");
                break;
            case 2:
                if(sread ==0 && swrite ==0 )
                {
                    swrite = 1;
                    printf("\nWriter writes to the file\n");
                }
                else
                {
                    if(sread == 1)
                        printf("\nCannot write while reads to file\n");
                    else
                    {
                        if(swrite == 1)
                            printf("\nAlready one writer writing to file\n");
                    }
                }
                break;
            case 3:
                if(r!=0)
                {
                    printf("\n The Reader %d closes the file\n", r);
                    r = r-1;
                    if(r == 0)
                    {
                        printf("\n Currently No readers are using file");
                        sread = 0;
                    }
                    else
                    {
                        if(r==1)
                            printf("\n Currently one readers are using file");
                        else
                            printf("\n Currently %d readers are using file", r);
                    }

                }
                break;
            case 4:
                if(swrite == 1)
                {
                    printf("\n Write closes the file");
                    swrite = 0;
                }
                else
                    printf("\n No writer writing to the file");
                break;

            case 5:
                if(sread=1)
                {
                    if(r==1)
                        printf("\n Reader is reading the file");
                    else
                        printf("%d Reader are reading file");
                }
                else
                {
                    if(swrite==1)
                        printf("\n A writer is writing the file");
                    else
                        printf("\n File is not in use");
                }
                break;
            case 6:
                break;
            }
        } while(ch!=6);
    }








