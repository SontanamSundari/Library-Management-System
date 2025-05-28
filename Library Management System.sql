CREATE  DATABASE library;
use library;
CREATE TABLE books(
id int primary key,
title varchar(50),
author varchar(50)
);
INSERT INTO books(id,title,author)VALUES 
(1, 'Atomic Habits', 'James Clear'),
(3, 'Think and Grow Rich', ' Napoleon Hill'),
(4, 'How to Win Friends and Influence People', 'Dale Carnegie'),
(5, 'The Subtle Art of Not Giving a F*ck', 'Mark Manson'),
(6, 'Can’t Hurt Me', 'David Goggins'),
(7, 'Make Your Bed', 'Admiral William H. McRaven'),
(8, 'Eat to Live', 'Joel Fuhrman'),
(9, 'The Power of Now', 'Eckhart Tolle'),
(10, 'The 7 Habits of Highly Effective People', 'Stephen R. Covey'),
 (11, 'The Power of Habit', 'Charles Duhigg'),
 (12, 'The Alchemist', 'Paulo Coelho'),
 (13, 'Ikigai', 'Francesc Miralles & Héctor García'),
(14, 'Principles: Life and Work', 'Ray Dalio'),
(15, 'Black Box Thinking', 'Matthew Syed'),
(16, 'The Lean Startup', 'Eric Ries'),
(17, 'Mindset: The New Psychology of Success', 'Carol S. Dweck'),
(18, 'Educated', 'Tara Westover'),
(19, 'The Art of Thinking Clearly', 'Rolf Dobelli'),
(20, 'The Obstacle Is the Way', 'Ryan Holiday');
select * from books;