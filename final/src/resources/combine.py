files = [
	'car.sql',
	'part.sql',
	'producttype.sql',
	'customer.sql',
	'product.sql',
	'listing.sql',
	'forum.sql',
]

lines = []


if __name__ == '__main__':
	for filepath in files:
		f = open(filepath, 'r')
		
		for line in f:
			lines.append(line)
		
		f.close()
	
	with open('out.sql', 'w') as f:
		for line in f:
			f.write(line)
			f.write('\n')
