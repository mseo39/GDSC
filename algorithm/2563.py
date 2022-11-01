'''
2563번 색종이

가로, 세로의 크기가 각각 200인 정사각형 모양의 흰색 도화지가 있다.
이 도화지 우이에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 생종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 얿이를 구하는 프로그램을 작성하시오

예를 들어 흰색 도화지 위엥 세장의 검은 색 색종이를 그림과 같은 모양으로 붙였다면
검은색 영역의 넓이는 260이 된다.


입력
: 첫째 줄에 색종이의 수가 주어짐다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다.
색종이를 붙인 위치는 두 개의 자연수로 주어지는데
첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고,
두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다.
색종이의 수는 100이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다.

출력
: 첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다.

내 생각 정리
: 입력값을 (x,y)일 때
(x,y)~(x+10,y+10)

겹치는 부분은 어떻게 처리해야 할까?
: 겹치는 (x1~y1)~(x2,y2)의 넓이를 색종이 수*(10*10)-(x2-x1)(y2-y1)

사각형에 해당하는 좌표를 배열에 저장하고 겹치는 부분의 개수를 찾으면 되지 않을 까?

'''
#2차원 배열을 생성하고 0으로 초기화
board=[[0]*100 for _ in range(100)]

#색종이 수를 입력
for num in range(int(input())):
    #각 색종이의 가로, 세로 거리
    x,y= map(int, input().split())
    #해당하는 부분을 1로 바꿔준다
    for x1 in range(x,x+10):
        for y1 in range(y,y+10):
            board[x1][y1]=1
total=0 #1의 개수를 저장할 변수
for i in range(100):
    #count함수를 이용하여 1의 개수를 수한다
    total+=board[i].count(1)

print(total)

# #각 색종이의 x좌표 배열
# length_x=[]
# #각 색종이의 y좌표 배열
# length_y=[]
# #넓이를 저장할 변수
# total=0

# #색종이 수를 입력
# n=int(input())
# #각 색종이의 가로, 세로 거리
# for num in range(n):
#     x,y= map(int, input().split())
#     total+=(10*10)
#     #set을 사용한 이유는 &를 이용하여 겹치는 부분을 찾기 위해서다
#     length_x.append(set(i for i in range(x,x+10)))
#     length_y.append(set(i for i in range(y,y+10)))

#     if len(length_x)==1:
#         total_x=length_x[0]
#         total_y=length_y[0]

#     for i in range(num):
#         x1=len(length_x[i]&length_x[num])
#         y1=len(length_y[i]&length_y[num])

#         total-=(x1*y1)

#     total_x=total_x&length_x[num]
#     total_y=total_y&length_y[num]
# if(n>2):
#     print(total+(len(total_x)*len(total_y)))
# else:
#     print(total)