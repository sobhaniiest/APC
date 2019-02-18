#include <arpa/inet.h>
#include <sys/socket.h>
#include <netdb.h>
#include <ifaddrs.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <linux/if_link.h>
#include <string.h>

int main(int argc, char *argv[])
{
  struct ifaddrs *ifaddr, *ifa;
  int n,i;
  char host[NI_MAXHOST];
  char buff[5][50];
  int j,k,flag;
  char addr[50],old[50],str[100];
  int len;

  i = 0;

  if (getifaddrs(&ifaddr) == -1) 
  {
      perror("getifaddrs");
      exit(EXIT_FAILURE);
  }

  for (ifa = ifaddr, n = 0; ifa != NULL; ifa = ifa->ifa_next, n++) 
  {
     if (ifa->ifa_addr == NULL)
          continue;
      if (ifa->ifa_addr->sa_family == AF_INET) 
      {
          //printf("%-8s\t", ifa->ifa_name);
          strcpy(buff[i],ifa->ifa_name);
          //printf("%-8s\t", buff[i]);
          i++;

          if (getnameinfo(ifa->ifa_addr,sizeof(struct sockaddr_in),host, NI_MAXHOST,NULL, 0, NI_NUMERICHOST) != 0) 
          {
              printf("getnameinfo() failed\n");
              exit(EXIT_FAILURE);
          }

          //printf("<%s>\n", host);
          strcpy(buff[i],host);
          //printf("<%s>\n", buff[i]);
          i++;

      } 
  }

  freeifaddrs(ifaddr);

  k = 0;
  flag = 0;
  for(j=0;j<strlen(buff[3]);j++)
  {
    if(flag == 2)
      break;
    if(buff[3][j] != '.')
    {
      addr[k] = buff[3][j];
      k++;
    }
    if(buff[3][j] == '.')
    {
      addr[k] = '.';
      k++;
      flag++;
    }
  }

  addr[k++] = '0';
  addr[k++] = '.';
  addr[k++] = '1';
  addr[k++] = '\0';


  printf("%s\n",addr);

  if(!(strcmp(addr,"\0")))
  {

  }
  else if(addr[0] == '1' && addr[1] == '9' && addr[2] == '2')
  {
    system("gsettings set org.gnome.system.proxy mode 'none'");
    strcpy(old,addr);
  }
  else
  {

        printf("%s\n",addr);

        system("gsettings set org.gnome.system.proxy mode 'manual'");

        sprintf(str,"gsettings set org.gnome.system.proxy.http host '%s'",addr);
        system(str);

        system("gsettings set org.gnome.system.proxy.http port 8080");

        bzero(str, sizeof(str));

        sprintf(str,"gsettings set org.gnome.system.proxy.https host '%s'",addr);
        system(str);

        system("gsettings set org.gnome.system.proxy.https port 8080");

        strcpy(old,addr);
  }


  while(1)
  {
    sleep(2);
    i = 0;

    if (getifaddrs(&ifaddr) == -1) 
    {
        perror("getifaddrs");
        exit(EXIT_FAILURE);
    }

    for (ifa = ifaddr, n = 0; ifa != NULL; ifa = ifa->ifa_next, n++) 
    {
       if (ifa->ifa_addr == NULL)
            continue;
        if (ifa->ifa_addr->sa_family == AF_INET) 
        {
            //printf("%-8s\t", ifa->ifa_name);
            strcpy(buff[i],ifa->ifa_name);
            //printf("%-8s\t", buff[i]);
            i++;

            if (getnameinfo(ifa->ifa_addr,sizeof(struct sockaddr_in),host, NI_MAXHOST,NULL, 0, NI_NUMERICHOST) != 0) 
            {
                printf("getnameinfo() failed\n");
                exit(EXIT_FAILURE);
            }

            //printf("<%s>\n", host);
            strcpy(buff[i],host);
            //printf("<%s>\n", buff[i]);
            i++;

        } 
    }

    freeifaddrs(ifaddr);

    k = 0;
    flag = 0;
    for(j=0;j<strlen(buff[3]);j++)
    {
      if(flag == 2)
        break;
      if(buff[3][j] != '.')
      {
        addr[k] = buff[3][j];
        k++;
      }
      if(buff[3][j] == '.')
      {
        addr[k] = '.';
        k++;
        flag++;
      }
    }

    addr[k++] = '0';
    addr[k++] = '.';
    addr[k++] = '1';
    addr[k++] = '\0';

    printf("%s\n",addr);

    if(!(strcmp(old,addr)))
      continue;
    else if(!(strcmp(addr,"\0")))
      continue;
    else if(addr[0] == '1' && addr[1] == '9' && addr[2] == '2')
    {
      system("gsettings set org.gnome.system.proxy mode 'none'");
      strcpy(old,addr);
    }
    else
    {

          printf("%s\n",addr);

          system("gsettings set org.gnome.system.proxy mode 'manual'");

          sprintf(str,"gsettings set org.gnome.system.proxy.http host '%s'",addr);
          system(str);

          system("gsettings set org.gnome.system.proxy.http port 8080");

          bzero(str, sizeof(str));

          sprintf(str,"gsettings set org.gnome.system.proxy.https host '%s'",addr);
          system(str);

          system("gsettings set org.gnome.system.proxy.https port 8080");

          strcpy(old,addr);
    }
  }

  exit(EXIT_SUCCESS);

}