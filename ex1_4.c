#include <stdio.h>
#include <shadow.h>

int main(void){
	struct spwd *spw;

	spw = getspnam("kbsong");
	printf("Login Name : %s\n", spw->sp_namp);	//로그인 이름 :kbsong
	printf("Passwd : %s\n", spw->sp_pwdp);		//비밀번호 : *
	printf("Last Change : %ld\n", spw->sp_lstchg);	//마지막으로 바뀐 변화

	return 0;
}

