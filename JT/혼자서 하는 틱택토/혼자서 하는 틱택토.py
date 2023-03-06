def solution(board):
    check_O_V, check_X_V = 0, 0
    count_O, count_X = 0, 0
    for i in range(3):
        for j in range(3):
            if board[i][j] == 'O':
                count_O += 1
            if board[i][j] == 'X':
                count_X += 1
        #check victory
        if board[i][0] == board[i][1] == board[i][2] != '.':
            if board[i][0] == 'O':
                check_O_V += 1
            else:
                check_X_V += 1
        if board[0][i] == board[1][i] == board[2][i] != '.':
            if board[0][i] == 'O':
                check_O_V += 1
            else:
                check_X_V += 1
    if board[0][0] == board[1][1] == board[2][2] != '.':
        if board[0][0] == 'O':
            check_O_V += 1
        else:
            check_X_V += 1
    if board[0][2] == board[1][1] == board[2][0] != '.':
        if board[0][2] == 'O':
            check_O_V += 1
        else:
            check_X_V += 1
    if count_O - count_X > 1:
        return 0
    if check_O_V and check_X_V:
        return 0
    if count_O < count_X:
        return 0
    if count_O > count_X and check_X_V:
        return 0
    if count_O == count_X and check_O_V:
        return 0
    return 1