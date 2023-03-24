#include<iostream>
#include<stdio.h>
#include<fstream>
#include<string>
#include <cstring>
#include<stdlib.h>
#include<string.h>
#include<cstring>
#include <conio.h>
#include <windows.h>
#include"schoolmap.h"        
#define INF 10000

using namespace std;

void SaveFile(schoolmap &s,string filename)
{
	ofstream ofile;
	ofile.open(filename);
	ofile << s.vernum << " "<<s.edgenum<<endl;
	for (int h =1; h <= s.vernum; h++)
		ofile << s.ver[h].sitename <<" "<< s.ver[h].siteintroduce << endl;;
	for(int i=1;i<=s.edgenum;i++)
				ofile << s.edg[i].start << " " << s.edg[i].end << " " << s.edg[i].weight << endl;
	
	ofile.close();
}
void color(short x)	//�Զ��庯���ݲ����ı���ɫ 
{
	if (x >= 0 && x <= 15)//������0-15�ķ�Χ��ɫ
		SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), x);	//ֻ��һ���������ı�������ɫ 
	else//Ĭ�ϵ���ɫ��ɫ
		SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
}
int LocateVex(schoolmap &s, string u)
{
	int i;
	for (i = 1; i <= s.vernum; i++)
		if (u == s.ver[i].sitename)
			return i;
	return false;
}

void Printmain(schoolmap &s)
{
		cout << "/****************** �����������μ���Ϣ����ϵͳ********************/" << endl;
		cout << endl;
		cout << "------------------------";
		color(6); 
		cout << "������";
		color(16);
		cout<<"-----------------------------" << endl;
		cout << "1.ǰ̨����" << endl;
		cout << "2.��̨����" << endl;
		cout << "0.�˳�ϵͳ" << endl;
		int inputnum;
		cin >> inputnum;
		switch (inputnum)
		{
		case 0:
		{
			SaveFile(s, "map.txt");
			exit(0);
		}
		case 1:
		{
			system("cls");    //���֮ǰ��ʾ�Ĵ���
			PrintSubsystem(s);
		}
		case 2:
		{
			system("cls");
			PrintBackground(s);

		}
		default:
		{
			SaveFile(s, "map.txt");
			cout << "ERRO!!!!!!!!!!!!!!!!!" << endl;
		}
		}
}

void PrintSubsystem(schoolmap &s)
{
	
	
		cout << "/****************** �����������μ���Ϣ����ϵͳ********************/" << endl;
		cout << endl;
		cout << "--------------------------";
		color(6);
		cout << "ǰ̨������ϵͳ";
		color(16);
		cout<<"---------------------------- " << endl;
		cout << "1.������Ϣ��ѯ" << endl;
		cout << "2.��·��ѯ" << endl;
		cout << "0.����" << endl;
		int num2;
		cin >> num2;
		switch (num2)
		{
		case 0:
		{
			system("cls");
			Printmain(s);
		}
		case 1:
		{
			system("cls");
			PrintFind(s);
			
		}
		case 2:
		{
			system("cls");
			FindWay(s);
			
		}
		default:
			cout << "ERRO!!!!!!!!!!!!!!!!!!!!!!" << endl;
		}
		
		
	

}
void PrintFind(schoolmap &s)
{
		cout << "/****************** �����������μ���Ϣ����ϵͳ********************/" << endl;
		cout << endl;
		cout << "-----------------------------";
		color(6);
		cout << "ǰ̨������ϵͳ����������Ϣ��ѯ";
		color(16);
		cout<<"----------------------" << endl;
		cout << "1.���ݾ������Ʋ�ѯ" << endl;
		cout << "2.���ݾ��㹦�ܲ�ѯ" << endl;
		cout << "0.����" << endl;
		int num3 = 10;
		cin >> num3;
		switch (num3)
		{
		case 0:
		{
				system("cls");
				PrintSubsystem(s);
		}
		case 1: 
		{
			system("cls");
             FindName(s);
		}
				
		case 2:
		{
			system("cls");
			FindFunction(s);
		}
		}
}
void FindName(schoolmap &s)
{
	
		cout << "/****************** �����������μ���Ϣ����ϵͳ********************/" << endl;
		cout << endl;
		cout << "-----------------------------";
		color(6);
		cout << "ǰ̨������ϵͳ�������ݾ������Ʋ�ѯ";
		color(16);
		cout<<"----------------------" << endl;
		cout << "��ϵͳ�ṩ���¾������" << endl;
		int f = 0;
		for (int i = 1; i <= s.vernum; i++)
		{
			cout << s.ver[i].sitename << "     ";
			f++;
			if (f%4==0)
				cout << endl;
		}
		cout << endl;
		cout << "������Ҫ��ѯ��������ƣ�" << endl;
		string sear;
		cin >> sear;
		for (int i = 0; i < s.vernum; i++)
		{
			if (sear == s.ver[i].sitename)
			{
				cout << s.ver[i].sitename << "�������ϢΪ��" << endl;
				cout << s.ver[i].siteintroduce << endl;
			}
		}
		cout << endl;
		cout << "��������������η���" << endl;
		int flag = 0;
		cin >> flag;
		if (flag != NULL)
		{
			system("cls");
			PrintFind(s);
		}

	

}
void FindFunction(schoolmap &s)
{
	cout << "/****************** �����������μ���Ϣ����ϵͳ********************/" << endl;
	cout << endl;
	cout << "-----------------------------";
	color(6);
	cout << "ǰ̨������ϵͳ�������ݾ��㹦�ܲ�ѯ";
	color(16);
	cout << "----------------------" << endl;
	cout << "���������ѯ���㹦�ܣ�" << endl;
	string find;
	cin >> find;
	char find_char[100];
	strcpy(find_char, find.c_str());
	for (int i = 0; i < s.vernum; i++)
	{
		string temp = s.ver[i].siteintroduce;
		char temp_char[100];
		strcpy(temp_char, temp.c_str());           //stringתchar
		if (KMP(temp_char, temp.length(), find_char, find.length()) != -1)
			cout << s.ver[i].sitename << "    ";
	}
	cout << endl;
	cout << "��������������η���" << endl;
	getch();
	system("cls");
	PrintFind(s);
}
void cal_next(char *str, int *next, int len)
{
	next[0] = -1;//next[0]��ʼ��Ϊ-1��-1��ʾ��������ͬ�����ǰ׺������׺
	int k = -1;//k��ʼ��Ϊ-1
	for (int q = 1; q <= len - 1; q++)
	{
		while (k > -1 && str[k + 1] != str[q])//�����һ����ͬ����ôk�ͱ��next[k]��next[k]��С��k�ģ�����kȡ�κ�ֵ��
		{
			k = next[k];//��ǰ����
		}
		if (str[k + 1] == str[q])//�����ͬ��k++
		{
			k = k + 1;
		}
		next[q] = k;//�����k��ֵ��������ͬ�����ǰ׺������׺��������next[q]
	}
}
int KMP(char *str, int slen, char *ptr, int plen)  //str����    ptr�Ӵ�
{
	int *next = new int[plen];
	cal_next(ptr, next, plen);//����next����
	int k = -1;
	for (int i = 0; i < slen; i++)
	{
		while (k >-1 && ptr[k + 1] != str[i])//ptr��str��ƥ�䣬��k>-1����ʾptr��str�в���ƥ�䣩
			k = next[k];//��ǰ����
		if (ptr[k + 1] == str[i])
			k = k + 1;
		if (k == plen - 1)//˵��k�ƶ���ptr����ĩ��
		{
			return i - plen + 1;//������Ӧ��λ��
		}
	}
	return -1;   //ƥ��ʧ��
}

void FindWay(schoolmap &s)
{
	cout << "/****************** �����������μ���Ϣ����ϵͳ********************/" << endl;
	cout << endl;
	cout << "------------------------------";
	color(6);
	cout << "ǰ̨������ϵͳ������·��ѯ";
	color(16);
	cout << "-------------------------------" << endl;
	cout << "1.��ѯ������������·��" << endl;
	cout << "2.��ѯ�������������·��" << endl;
	cout << "0.����" << endl;
	int num2;
	cin >> num2;
	switch (num2)
	{
	case 0:
	{
		system("cls");
		PrintSubsystem(s);
	}
	case 1:
	{
		system("cls");
		FindWay_shortest(s);

	}
	case 2:
	{
		system("cls");
		FindWay_all(s);
	}
	default:
		cout << "ERRO!!!!!!!!!!!!!!!!!!!!!!" << endl;
	}
}
void FindWay_all(schoolmap &s)
{
	string start_place, aim_place;
	int path[1000], dis[1000], visit[1000];
	bool DfsPath;
	int initialize;
	cout << "/****************** �����������μ���Ϣ����ϵͳ********************/" << endl;
	cout << endl;
	cout << "------------------------------";
	color(6);
	cout << "ǰ̨������ϵͳ������·��ѯ";
	color(16);
	cout << "-------------------------------" << endl;
	cout << "��ϵͳ�ṩ���¾������" << endl;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		if (i % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��" << s.vernum << "������" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "Ŀǰ����·�����£�" << endl;
	int fff = 0;
	for (int m = 1; m <= s.edgenum; m++)
	{
		fff++;
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
		if (fff % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��" << s.edgenum << "��·��" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "���������ĵ�ǰλ�ã�" << endl;
	cin >> start_place;
	cout << "����������ǰ���ĵص㣺" << endl;
	cin >> aim_place;
	cout << endl;
	cout << endl;
	int start_site = LocateVex(s, start_place);//���
	int aim_site = LocateVex(s, aim_place);//�յ�
	cout << "������������·��Ϊ��" << endl;
	cout << endl;
	DfsPath = false;
	initialize = 0;
	DFS(start_site, start_site, aim_site, 0, path, dis, visit, DfsPath, initialize, s);
	cout << endl;
	cout << "-------------------------------------------" << endl;
	cout << "��������������η���" << endl;
	getch();
	system("cls");
	PrintSubsystem(s);

}
void FindWay_shortest(schoolmap &s)
{
	string start_place, aim_place;
	int path[1000], dis[1000], visit[1000];
	bool DfsPath;
	cout << "/****************** �����������μ���Ϣ����ϵͳ********************/" << endl;
	cout << endl;
	cout << "-------------------------------";
	color(6);
	cout << "ǰ̨������ϵͳ������·��ѯ";
	color(16);
	cout << "-------------------------------" << endl;
	cout << "��ϵͳ�ṩ���¾������" << endl;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		if (i % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��" << s.vernum << "������" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "Ŀǰ����·�����£�" << endl;
	int fff = 0;
	for (int m = 1; m <= s.edgenum; m++)
	{
		fff++;
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
		if (fff % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��" << s.edgenum << "��·��" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "���������ĵ�ǰλ�ã�" << endl;
	cin >> start_place;
	cout << "����������ǰ���ĵص㣺" << endl;
	cin >> aim_place;
	cout << endl;
	cout << endl;

	int start_site = LocateVex(s, start_place);//���
	int aim_site = LocateVex(s, aim_place);//�յ�
	
	cout << "���ݵ�����·��Ϊ��" << endl;
	Dijkstra(start_site,aim_site,path,dis,visit,s);
	searchPath(aim_site,start_site,path,s);

	cout << endl;
	cout << "ȫ�̳�����λ���ף���" << dis[aim_site] << endl;
	cout << "��������������η���" << endl;
	getch();
	system("cls");
	PrintSubsystem(s);
}
void DFS(int now, int start, int end, int sum, int *path, int *dis, int *visit,bool DfsPath, int initialize,schoolmap &s)
{
	if (initialize == 0)  //����һ�γ�ʼ��
	{
		for (int i = 1; i <= 100; i++)
		{
			path[i] = -1;   // ��¼��һ�ڵ�
			visit[i] = 0;   //�Ƿ����
		}
	}

	if (now == end)
	{
		searchPath(end, start,path, s);
		DfsPath = true;
		cout << "     ·������Ϊ��  " << sum << " (��λ����)       "<<endl;
		cout << endl;
		return;
	}
	visit[now] = 1;
	for (int v = 1; v <= s.vernum; v++)
		if (!visit[v] && s.AdjMatrix[now][v] < INF) 
		{
			int tmp = path[v]; 
			path[v] = now;
			visit[v] = 1;
			initialize++;
			DFS(v, start, end, sum + s.AdjMatrix[now][v], path, dis, visit, DfsPath, initialize, s);
			visit[v] = 0;
			path[v] = tmp;
		}
}
void Dijkstra(int start, int end, int *path, int *dis, int *visit, schoolmap &s)
{
	for (int i = 1; i <= 100; i++)
	{
		dis[i] = INF; //����Դ��
		path[i] = -1;   // ��¼��һ�ڵ�
		visit[i] = 0;   //�Ƿ����
	}
	for (int j = 1; j <= s.vernum; j++)
		if (s.AdjMatrix[start][j] < INF)
		{
			dis[j] = s.AdjMatrix[start][j];
			path[j] = start;
		}
	dis[start] = 0;//������Ϊ0
	for (int i = 1; i <= s.vernum; i++)
	{
		int mn = INF, cur;
		for (int j = 1; j <= s.vernum; j++)
			if (!visit[j] && dis[j] < mn)
			{
				mn = dis[j], cur = j;
			}
		visit[cur] = 1;//�ѱ�����
		for (int k = 1; k <= s.vernum; k++)
			if (dis[k] > dis[cur] + s.AdjMatrix[cur][k])//k��Դ��ľ������ ��ǰ���ʵ�Դ��+��ǰ���ʵ�k
			{
				dis[k] = dis[cur] + s.AdjMatrix[cur][k];
				path[k] = cur;
			}
	}
}
void searchPath(int now_place, int start,int *path, schoolmap &s)
{
	if (now_place == start)
	{
		cout << s.ver[start].sitename;  //����㿪ʼ��ӡ
		return;
	}
	searchPath(path[now_place], start,path, s);
	cout << "-->" << s.ver[now_place].sitename; //����ӡ������ĵ�ǰ��
}

void PrintBackground(schoolmap &s)
{
	cout << "/****************** �����������μ���Ϣ����ϵͳ********************/" << endl;
	cout << endl;
	cout << "-----------------------------";
	color(6);
	cout << "��̨������ϵͳ";
	color(16);
	cout << "----------------------" << endl;
	cout << "�������¼���룺" << endl;
	char log_in[25];
	char password[25] = "666666";
	int k = 3;
	for (k = 3; k > 0; k--)
	{
		in_password(log_in);
		if (strcmp(log_in, password) == 0)
		{
			cout << endl;
			cout << "��¼�ɹ�" << endl;
			system("cls");
			PrintBackground_afterlogin_menu(s);
		}
		else
		{
			if (k > 1)
			{
				cout << endl;
				cout << "��������㻹��" << k - 1 << "���������" << endl;
			}
		}
	}
	cout << endl;
	cout << "--------------------------------------------------" << endl;
	cout << "������󣬰�������˳���" << endl;
	getchar();
	getchar();
	system("cls");
	Printmain(s);
}
void in_password(char *password)
{
	int i;
	char ch;
	while (1) {
		i = 0;
		while (1) {
			ch = getch();
			if (ch == '\r')
				break;
			else if (ch == '\b') {
				if (i > 0) {
					printf("\b \b");
					i--;
				}
				continue;
			}
			printf("*");
			password[i++] = ch;
		}
		password[i] = 0;
		break;
	}
}
void PrintBackground_afterlogin_menu(schoolmap &s)
{
	cout << "/****************** �����������μ���Ϣ����ϵͳ********************/" << endl;
	cout << endl;
	cout << "-----------------------------";
	color(6);
	cout << "��̨������ϵͳ";
	color(16);
	cout << "-----------------------------" << endl;
	cout << "1.�޸�һ�����о���������Ϣ" << endl;
	cout << "2.����һ���¾��㼰�������Ϣ" << endl;
	cout << "3.����һ���µ�·��" << endl;
	cout << "4.ɾ��һ�����㼰�������Ϣ" << endl;
	cout << "5.ɾ��һ��·��" << endl;
	cout << "0.����������" << endl;
	int num6;
	cin >> num6;
	switch (num6)
	{
	case 0:
	{
		system("cls");
		Printmain(s);
	}
	case 1:
	{
		system("cls");
		ModifySite(s);
	}
	case 2:
	{
		system("cls");
		AddSite(s);
	}
	case 3:
	{
		system("cls");
		AddEdge(s);
	}
	case 4:
	{
		system("cls");
		DeleteSite(s);
	}
	case 5:
	{
		system("cls");
		DeleteEdge(s);
	}
	}
}
void ModifySite(schoolmap &s)
{
	string modify_name;
	cout << "--------------------------";
	color(6);
	cout << "��̨������ϵͳ����������Ϣ�޸�";
	color(16);
	cout << "---------------------------" << endl;
	cout << "��ϵͳ���ṩ���¾������" << endl;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		if (i % 4 == 0)
			cout << endl;
	}
	int flag = 0;
	cout << endl;
	cout << "������Ҫ�޸ĵľ������ƣ�" << endl;
	cin >> modify_name;
	for (int i = 1; i <= s.vernum; i++)
	{
		if (modify_name == s.ver[i].sitename)
		{
			flag = 1;
			cout << "�����޸ĵľ�������Ϊ��" << s.ver[i].sitename << endl;
			cout << "�����������޸ľ���Ľ������ݣ�" << endl;
			cin >> s.ver[i].siteintroduce;
			cout << "���Ѿ�������  " << s.ver[i].sitename << "  ����Ϣ�޸�Ϊ:" << endl;
			cout << s.ver[i].siteintroduce << endl;
			cout << "---------------------------" << endl;
			cout << "��������������η���" << endl;
			getchar();
			getchar();
			system("cls");
			PrintBackground_afterlogin_menu(s);
		}
	}
	if (flag == 0)
	{
		cout << "���������Ϣ���������������������޸ĵľ������ƣ�" << endl;
		ModifySite(s);
	}
}
void AddSite(schoolmap &s)
{
	string newsite_name, newsite_introduce;
	string v1, v2;
	cout << "--------------------------";
	color(6);
	cout << "��̨������ϵͳ����������Ϣ����";
	color(16);
	cout << "---------------------------" << endl;
	cout << "Ŀǰ���о������£�" << endl;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		if (i % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��" << s.vernum << "��" << endl;
	cout << "������Ҫ���ӵľ������ƺ;����飺" << endl;
	s.vernum = s.vernum + 1;
	cin >> s.ver[s.vernum].sitename >> s.ver[s.vernum].siteintroduce;

	for (int i = 1; i <= s.vernum; i++)
	{
		s.AdjMatrix[i][s.vernum] = INF;
	}
	for (int j = 1; j <= s.vernum; j++)    //ͼ��ʼ��
	{
		s.AdjMatrix[s.vernum][j] = INF;
	}


	cout << "Ŀǰ�����¹� " << s.vernum << " �����㣺" << endl;
	int k = 0;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		k++;
		if (k % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��������������η���" << endl;
	getchar();
	getchar();
	system("cls");
	PrintBackground_afterlogin_menu(s);
}
void DeleteSite(schoolmap &s)
{
	string deletesite_name, temp_name, temp_introduce;
	cout << "--------------------------";
	color(6);
	cout << "��̨������ϵͳ����������Ϣɾ��";
	color(16);
	cout << "---------------------------" << endl;
	cout << "Ŀǰ���о������£�" << endl;
	int f = 0;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		f++;
		if (f % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��" << s.vernum << "��" << endl;
	cout << "������Ҫɾ���ľ�������" << endl;
	cin >> deletesite_name;
	int flag = 0;
	int delete_site_locate;
	for (int i = 1; i <= s.vernum; i++)
	{
		if (deletesite_name == s.ver[i].sitename)
		{                                              //��ʱiΪɾȥ����±�
			flag = 1;
			delete_site_locate=i;
			//for (int j = 1; j <= s.vernum; j++)  //�ڽӾ�����ɾȥ��i�����У������е�ֵΪINF����ʾ�õ㲻���καߵĶ˵㣩
			//{
			//	s.AdjMatrix[i][j] = INF;
			//	s.AdjMatrix[j][i] = INF;
			//}
			for (int i = 1; i < delete_site_locate; i++)                     //���Ϸ��������ƶ�
			{
				for (int j = delete_site_locate; j < s.vernum; j++)
				{
					s.AdjMatrix[i][j] = s.AdjMatrix[i][j + 1];
				}
			}
			for (int i = delete_site_locate; i < s.vernum ; i++)             //���·��������ƶ�
			{
				for (int j = 1; j < delete_site_locate; j++)
				{
					s.AdjMatrix[i][j] = s.AdjMatrix[i + 1][j];
				}
			}
			for (int i = delete_site_locate+1; i < s.vernum; i++)
			{
				for (int j = delete_site_locate; j < s.vernum; j++)
				{
					s.AdjMatrix[i][j] = s.AdjMatrix[i][j + 1];                 //���·��������ƶ�

				}
			}
			for (int i = delete_site_locate; i < s.vernum; i++)
			{
				for (int j = delete_site_locate; j < s.vernum; j++)
				{
					s.AdjMatrix[i][j] = s.AdjMatrix[i + 1][j];                        //���·��������ƶ�

				}
			}

			for (int j = i; j < s.vernum; j++)              //��ɾȥ�ĵ�Ӵ���������ɾȥ
			{
				s.ver[j].sitename = s.ver[j + 1].sitename;
				s.ver[j].siteintroduce = s.ver[j + 1].siteintroduce;
			}
			//·�����޸�    �ڽӾ����еĶ�Ӧ�ıߵø�ֵINF����ߵ�����øı䣬��������øı�
			s.vernum = s.vernum - 1;
			for (int ii =s.edgenum; ii>=1; ii--)  //��ߵ���������õ��йصı߶�ɾȥ
			{
				if (deletesite_name == s.edg[ii].start || deletesite_name == s.edg[ii].end) //���������ҵ���ɾ���ı�
					delete_edge(s, ii);                           //����ɾ��,ɾ���󣬱������е�λ�ñ��ˣ�ͬʱ������Ҳ�Ǳ�������
			}
			s.edgenum = s.edgenum;
			cout << endl;
			cout << "��ɾ����һ�������Ŀǰ�����¹� " << s.vernum << " �����㣺" << endl;
			for (int i = 1; i <= s.vernum; i++)
			{
				cout << s.ver[i].sitename << "     ";
				if (i % 4 == 0)
					cout << endl;
			}
			cout << endl;
			cout << "-----------------------------------------------" << endl;
			cout << "��ɾ����һ�������Ŀǰ�����¹� " << s.edgenum << " ��·��" << endl;
			for (int m = 1; m <= s.edgenum; m++)
			{
				cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
				if (m % 4 == 0)
					cout << endl;
			}
			cout << endl;
			cout << "��������������η���" << endl;
			getchar();
			getchar();
			system("cls");
			PrintBackground_afterlogin_menu(s);
		}
	}
	if (flag == 0)
	{
		cout << "û�д˾��㣬���������룺" << endl;
		DeleteSite(s);
	}
}
void delete_edge(schoolmap &s, int pos)
{
	for (int i = pos; i < s.edgenum; i++)
		s.edg[i] = s.edg[i + 1];
	s.edgenum--;
}
void DeleteEdge(schoolmap &s)
{
	string delete_start_name, delete_end_name;
	int aa, bb;
	cout << "--------------------------";
	color(6);
	cout << "��̨������ϵͳ����·������";
	color(16);
	cout << "--------------------------" << endl;
	cout << "Ŀǰ����·�����£�" << endl;
	for (int m = 1; m <= s.edgenum; m++)
	{
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
		if (m % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��" << s.edgenum << "��·��" << endl;
	cout << "������Ҫɾ����·���������յ㣺" << endl;
	cin >> delete_start_name >> delete_end_name;
	aa = LocateVex(s, delete_start_name);       //���ڽӾ����н���2������붨ΪINF
	bb = LocateVex(s, delete_end_name);
	s.AdjMatrix[aa][bb] = INF;
	s.AdjMatrix[bb][aa] = INF;
	for (int i = 1; i <= s.edgenum; i++)   //�ڱ������и���ɾȥ�ı�
	{
		if (delete_start_name == s.edg[i].start&&delete_end_name == s.edg[i].end || delete_start_name == s.edg[i].end&&delete_end_name == s.edg[i].start)
		{
			delete_edge(s, i);
		}
	}
	cout << "��ɾ����һ��·����Ŀǰ����·�����£�" << endl;
	for (int m = 1; m <= s.edgenum; m++)
	{
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
		if (m % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��" << s.edgenum << "��·��" << endl;
	cout << "��������������η���" << endl;
	getchar();
	getchar();
	system("cls");
	PrintBackground_afterlogin_menu(s);
}
void AddEdge(schoolmap &s)
{
	string new_start, new_end;
	int new_weight;
	int ii, jj;
	cout << "--------------------------";
	color(6);
	cout << "��̨������ϵͳ����·������";
	color(16);
	cout << "--------------------------" << endl;
	cout << "Ŀǰ���о������£�" << endl;
	int f = 0;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		f++;
		if (f % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��" << s.vernum << "��" << endl;
	cout << "=======================================================================" << endl;
	cout << "Ŀǰ����·�����£�" << endl;
	for (int m = 1; m <= s.edgenum; m++)
	{
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
		if (m % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "��" << s.edgenum << "��·��" << endl;
	cout << "������Ҫ���ӵ�·������㣬�յ㼰���ȣ�" << endl;
	cin >> new_start >> new_end >> new_weight;      //ͼ����Ҫ���ӣ��ߵĽṹ��Ҳ��Ҫ����
	s.edgenum++;
	s.edg[s.edgenum].start = new_start;
	s.edg[s.edgenum].end = new_end;
	s.edg[s.edgenum].weight = new_weight;

	ii = LocateVex(s, new_start);
	jj = LocateVex(s, new_end);
	s.AdjMatrix[ii][jj] = new_weight;
	s.AdjMatrix[jj][ii] = new_weight;
	/*cout << "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"<<endl;
	int fff = 0;
	for(int i=1;i<=s.vernum;i++)
		for (int j = 1; j <= s.vernum; j++)
		{
			cout << s.AdjMatrix[i][j] << "  ";
			fff++;
			if (fff%s.vernum == 0)
				cout << endl;
		}
	cout << endl;
	cout << "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"<<endl;*/
	cout << "��������һ��·����Ŀǰ����·�����£�" << endl;
	for (int m = 1; m <= s.edgenum; m++)
	{
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
	}
	cout << endl;
	cout << "��" << s.edgenum << "��·��" << endl;
	cout << "��������������η���" << endl;
	getchar();
	getchar();
	system("cls");
	PrintBackground_afterlogin_menu(s);
}





