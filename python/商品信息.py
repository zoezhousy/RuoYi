from datetime import datetime
from bs4 import BeautifulSoup
import requests
import pandas as pd
import re


def is_valid_date(info, pattern):
    if datetime.strptime(info, pattern):
        return True  
    else:
        return False

url = "https://category.dangdang.com/cp01.58.03.00.00.00.html"
try:
    response = requests.get(url)
    if response.status_code == 200:
        soup = BeautifulSoup(response.text, 'html.parser')

        title = soup.title.string if soup.title else 'No title found'

        print("The title of the webpage is ", title)
        books = soup.find('ul',class_='bigimg')
        books_data = []

        # 书籍元素
        for book in books.find_all('li'):
            name = book.find('a', class_='pic')['title']  # 书籍标题
            price = book.find('span', class_='search_now_price').text.strip()[1:]  # 价格
            comments = book.find('a', class_='search_comment_num').text.strip()  # 评论数
            author_info = book.find('p', class_='search_book_author').text.split('/')  # 作者信息

            author = None
            publish_date = None
            publisher = None
            try:
                author = author_info[0].strip() # 作者
            except IndexError:
                continue
            try:
                publish_date = author_info[1].strip() # 出版日期
            except IndexError:
                continue
            try:
                publisher = author_info[2].strip()[:-7] # 出版社
            except IndexError:
                continue     

            # 输出信息
            # print("Title:", title)
            # print("Price:", price)
            # print("Comments:", comments)
            # print("Author:", author)
            # print("Publish Date:", publish_date)
            # if publisher != None:
                # print("Publisher:", publisher)
            # print('-' * 50)

            books_data.append([name, price, comments, author, publish_date, publisher])
        
        # dataframe
        df = pd.DataFrame(books_data, columns=['Name', 'Price', 'Comments', 'Author', 'Publish Date', 'Publisher'])

        # 保存到CSV文件
        df.to_csv('books.csv', index=False, encoding='utf-8-sig')


        print("Data saved to CSV file successfully.")


    else:
        print("fail to retrieve the webpage")
    # get

    # save

except requests.exceptions.RequestException as e:
    # 如果请求出错，打印错误信息
    print('Error:', e)

