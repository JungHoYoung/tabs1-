#include <stdio.h>
#include <pwd.h>

int main(void){
	struct passwd *pw;

	pw = getpwnam("kbsong");			//kbsong이라는 이름을 얻어와서 passwd 구조체 접근
	printf("UID : %d\n", (int)pw->pw_uid);		//사용 아이디 얻기
	printf("Home Directory : %s\n", pw->pw_dir);	//홈 디렉토리 얻기

	return 0;
}

