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
push 2
lfp
add
lw
push 1
lfp
add
sw
push 2
push 1
lfp
add
sw
push 1
lfp
add
lw
print
push 2
lfp
add
lw
push 1
add
print
push 1
lfp
add
lw
push 2
add
print
srv
pop
pop
sra
pop
pop
pop
sfp
lrv
lra
js
