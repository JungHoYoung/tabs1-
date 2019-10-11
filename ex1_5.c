#include <stdio.h>
#include <shadow.h>

int main(void){
	struct spwd *spw;				
	int n;

	for(n=0; n<3; n++){
		spw = getspent();				//getspent로 spwd구조체 읽어오기
		printf("LoginName : %s, Passwd : %s\n", spw->sp_namp,
				spw->sp_pwdp);			//로그인한 이름과 비밀번호 나열
	}
	return 0;
}

