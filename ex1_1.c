#include <unistd.h>
#include <pwd.h>
#include <stdio.h>

int main(void){
	struct passwd *pw; 				

	pw = getpwuid(getuid());			//현재 사용 아이디로 비밀번호 파일 읽어오기
	printf("UID :%d\n", (int)pw->pw_uid);		//현재 사용 아이디
	printf("Login Name : %s\n", pw->pw_name);	//현재 사용 이름

	return 0;
}

