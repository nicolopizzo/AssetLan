push 0
push 0
push 0
push function0
lfp
push 0
push 2
lfp
push -4
lfp
add
lw
js
halt

function0:
cfp
lra
push 1
lfp
add
lw
print
srv
sra
pop
pop
pop
sfp
lrv
lra
js
