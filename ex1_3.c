#include <stdio.h>
#include <pwd.h>

int main(void){
	struct passwd *pw;
	int n;
	for(n=0; n<3; n++){				///etc/passwd파일 순차적(3번)읽기
		pw = getpwent();			//getpwent로 구조체 읽어오기 
		printf("UID : %d, LoginName : %s\n", (int)pw->pw_uid, 
				pw->pw_name);		//사용 아이디와 로그인  이름 나열
	}

	return 0;
	
}

