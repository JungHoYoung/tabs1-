#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main(void){
	gid_t gid, egid;

	gid = getgid();
	egid = getegid();

	printf("GID = %d, EGID = %d\n", (int)gid, (int)egid);	//그룹아이디와 유효사용자 아이디를 불러오기
	
	return 0;
}

