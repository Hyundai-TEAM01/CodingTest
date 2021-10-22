class Solution {
    public int[] solution(int rows, int columns, int[][] queries){
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        
        int idx = 1;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = idx++;
            }
        }
        

        for(int i = 0; i < queries.length; i++){
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            int temp = Integer.MAX_VALUE;
            
            int before = 0;
            int now_x = x1;
            int now_y = y1;
            boolean start = false;
            while(now_x <= x2 && now_y <= y2 && x1 <= now_x && y1 <= now_y){
                int now_val = 0;
                if(!start){
                    start = true;
                    before = board[now_x][now_y]; // ���� �� ����
                    board[now_x][now_y] = board[now_x+1][now_y];
                    temp = Math.min(board[now_x][now_y],temp);
                    now_y++;
                }else{
                    if(now_x == x1 && now_y == y1){
                        now_val = board[now_x][now_y];
                        board[now_x][now_y] = before;
                        before = now_val;
                        break;
                    }
                    
                    if(now_x == x1 && now_y < y2){
                        // ������ �̵�
                        now_val = board[now_x][now_y];
                        board[now_x][now_y] = before;
                        before = now_val;
                        now_y++;

                    }else if(now_y == y2 && now_x < x2){
                        // �Ʒ��� �̵�
                        now_val = board[now_x][now_y];
                        board[now_x][now_y] = before;
                        before = now_val;
                        now_x++;
                    }else if(now_x == x2 && now_y > y1){
                        //�������� �̵�
                        now_val = board[now_x][now_y];
                        board[now_x][now_y] = before;
                        before = now_val;
                        now_y--;

                    }else{ // ���� �̵�
                        now_val = board[now_x][now_y];
                        board[now_x][now_y] = before;
                        before = now_val;
                        now_x--;
                    }
                }
                 temp = Math.min(before,temp);
            }
            answer[i] = temp;
        }
        
        return answer;
    }
}