files = [
	'car.sql',
	'part.sql',
	'producttype.sql',
	'customer.sql',
	'product.sql',
	'listing.sql',
	'forum.sql',
]

outname = 'out.sql'
dropname = 'drop.sql'

lines = []
droplines = []


if __name__ == '__main__':

	for filepath in files:
	
		f = open(filepath, 'r')
		
		for line in f:
		
			#if it has 'drop' in it, append it to the droplines file
			if 'DROP' in line.upper():
				droplines.append(line.replace('--',''))
			
			#append line normally
			lines.append(line)
		
		f.close()
	
	with open(outname, 'w') as f:
		for line in lines:
			f.write(line)
			
	with open(dropname, 'w') as f:
		for line in droplines:
			f.write(line)
			
	
